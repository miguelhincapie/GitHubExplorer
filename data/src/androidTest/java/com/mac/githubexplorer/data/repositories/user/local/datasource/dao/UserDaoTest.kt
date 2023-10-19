package com.mac.githubexplorer.data.repositories.user.local.datasource.dao

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import androidx.test.platform.app.InstrumentationRegistry
import app.cash.turbine.test
import com.mac.githubexplorer.data.repositories.commons.local.GitHubDatabase
import com.mac.githubexplorer.data.repositories.user.local.UserLocalTestUtil
import com.mac.githubexplorer.data.repositories.user.local.entity.UserEntity
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch

@RunWith(AndroidJUnit4::class)
@MediumTest
class UserDaoTest {

    private lateinit var db: GitHubDatabase
    private lateinit var sut: UserDao
    private val userLocalTestUtil = UserLocalTestUtil()
    private val userOneName = "userOneName"
    private val userTwoName = "userTwoName"
    private val userThreeName = "userThreeName"
    private lateinit var users: MutableList<UserEntity>

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(
            context, GitHubDatabase::class.java
        ).allowMainThreadQueries().build()
        sut = db.userDao()

        users = mutableListOf(
            userLocalTestUtil.createDbUser(1, userOneName),
            userLocalTestUtil.createDbUser(2, userTwoName),
            userLocalTestUtil.createDbUser(3, userThreeName),
        )
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun getAll() = runTest {
        sut.insertAll(users)
        // Using latch as one of possible approaches to collect flow,
        // check out getByLogin() and loadAllByIds() for different approaches.
        val latch = CountDownLatch(1)
        val job = async(Dispatchers.IO) {
            sut.getAll().collect {
                assertEquals(users.size, it.size)
                assertEquals(users[0].id, it[0].id)
                assertEquals(users[0].name, it[0].name)
                assertEquals(users[1].id, it[1].id)
                assertEquals(users[1].name, it[1].name)
                assertEquals(users[2].id, it[2].id)
                assertEquals(users[2].name, it[2].name)
                latch.countDown()
            }
        }
        @Suppress("BlockingMethodInNonBlockingContext")
        latch.await()
        job.cancelAndJoin()
    }

    @Test
    fun getByLogin() = runTest {
        sut.insertAll(users)

        // Depend on what are u testing, you can just call coroutine's terminal operators
        val result = sut.getByLogin(userOneName).first()

        assertEquals(users[0].id, result?.id)
        assertEquals(users[0].name, result?.name)
    }

    @Test
    fun loadByLogin() = runTest {
        sut.insertAll(users)

        val result = sut.loadByLogin(userOneName)

        assertEquals(users.first().id, result?.id)
        assertEquals(users.first().name, result?.name)
    }

    @Test
    fun loadAllByIds() = runTest {
        sut.insertAll(users)

        // Collecting using Turbine library
        sut.loadAllByIds(listOf(1, 2, 3)).test {
            awaitItem().let {
                assertEquals(users.size, it.size)
                assertEquals(users[0].id, it[0].id)
                assertEquals(users[0].name, it[0].name)
                assertEquals(users[1].id, it[1].id)
                assertEquals(users[1].name, it[1].name)
                assertEquals(users[2].id, it[2].id)
                assertEquals(users[2].name, it[2].name)
            }
            cancel()
            ensureAllEventsConsumed()
        }
    }

    @Test
    fun findByName() = runTest {
        users[0] = users[0].copy(name = userOneName)
        sut.insertAll(users)

        sut.findByName(userOneName).test {
            awaitItem().let {
                assertEquals(users[0].id, it?.id)
                assertEquals(users[0].name, it?.name)
            }
            cancel()
            ensureAllEventsConsumed()
        }
    }

    @Test
    fun insertAllAndReplacesOnConflict() = runTest {
        sut.insertAll(users)
        val modifiedNameOne = "$userOneName modified for replace conflict"
        val modifiedNameTwo = "$userTwoName modified for replace conflict"
        val modifiedNameThree = "$userThreeName modified for replace conflict"

        users[0] = users[0].copy(name = modifiedNameOne)
        users[1] = users[1].copy(name = modifiedNameTwo)
        users[2] = users[2].copy(name = modifiedNameThree)
        sut.insertAll(users)

        sut.getAll().test {
            awaitItem().let {
                assertEquals(users.size, it.size)
                assertEquals(users[0].id, it[0].id)
                assertEquals(users[0].name, it[0].name)
                assertEquals(users[1].id, it[1].id)
                assertEquals(users[1].name, it[1].name)
                assertEquals(users[2].id, it[2].id)
                assertEquals(users[2].name, it[2].name)
            }
            cancel()
            ensureAllEventsConsumed()
        }
    }

    @Test
    fun insertAndReplacesOnConflict() = runTest {
        sut.insertAll(users)
        val modifiedNameOne = "$userOneName modified for replace conflict"

        users[0] = users[0].copy(name = modifiedNameOne)
        sut.insert(users[0])

        sut.findByName(modifiedNameOne).test {
            awaitItem().let {
                assertEquals(users[0].id, it?.id)
                assertEquals(users[0].name, it?.name)
            }
            cancel()
            ensureAllEventsConsumed()
        }
    }

    @Test
    fun delete() = runTest {
        sut.insertAll(users)

        sut.delete(users[0])

        assertEquals(null, sut.loadByLogin(userOneName))
        sut.getAll().test {
            assertEquals(2, awaitItem().size)
            cancel()
            ensureAllEventsConsumed()
        }
    }

    @Test
    fun deleteAll() = runTest {
        sut.insertAll(users)

        sut.delete(users)

        sut.getAll().test {
            assertEquals(0, awaitItem().size)
            cancel()
            ensureAllEventsConsumed()
        }
    }
}
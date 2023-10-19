package com.mac.githubexplorer.data.repositories.user.local.datasource

import app.cash.turbine.test
import com.mac.githubexplorer.data.repositories.user.local.UserLocalTestUtil
import com.mac.githubexplorer.data.repositories.user.local.datasource.dao.UserDao
import com.mac.githubexplorer.data.repositories.user.local.mapper.UserLocalMapper
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.coVerifySequence
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import io.mockk.verifySequence
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class UserLocalDataSourceImplTest {

    @MockK
    lateinit var userDao: UserDao

    @MockK
    lateinit var userLocalMapper: UserLocalMapper
    private val userLocalTestUtil = UserLocalTestUtil()
    private val expectedUserId = 1234
    private val expectedUserLogin = "expectedUserLogin1"

    private lateinit var sut: UserLocalDataSource

    @BeforeEach
    fun setUp() {
        sut = UserLocalDataSourceImpl(userDao, userLocalMapper)
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun loadUser() = runTest {
        val expectedEntityUser = userLocalTestUtil.createDbUser(expectedUserId, expectedUserLogin)
        val expectedDomainUser = userLocalTestUtil.createDomainModel(expectedEntityUser)
        coEvery { userDao.loadByLogin(any()) } returns expectedEntityUser
        every { userLocalMapper.userToDomain(any()) } returns expectedDomainUser

        val resultDomainUser = sut.loadUser(expectedUserLogin)

        assertNotNull(resultDomainUser)
        assertEquals(expectedDomainUser.id, resultDomainUser!!.id)
        assertEquals(expectedDomainUser.login, resultDomainUser.login)
    }

    @Test
    fun `loadUser empty dao answer`() = runTest {
        val expectedUserLogin = "expectedUserLogin1"
        coEvery { userDao.loadByLogin(any()) } returns null

        val resultDomainUser = sut.loadUser(expectedUserLogin)

        assertNull(resultDomainUser)
    }

    @Test
    fun getUser() = runTest {
        val expectedEntityUser1 = userLocalTestUtil.createDbUser(expectedUserId, expectedUserLogin)
        val expectedDomainUser = userLocalTestUtil.createDomainModel(expectedEntityUser1)
        coEvery { userDao.getByLogin(any()) } returns flowOf(
            expectedEntityUser1,
            expectedEntityUser1
        )
        every { userLocalMapper.userToDomain(any()) } returns expectedDomainUser

        sut.getUser(expectedUserLogin).test {
            awaitItem().let {
                assertNotNull(it)
                assertEquals(expectedDomainUser.id, it!!.id)
                assertEquals(expectedDomainUser.login, it.login)
            }
            awaitComplete()
        }
        // Behavior verification
        verify(exactly = 1) {
            userDao.getByLogin(any())
            userLocalMapper.userToDomain(any())
        }
        verifySequence {
            userDao.getByLogin(any())
            userLocalMapper.userToDomain(any())
        }
    }

    @Test
    fun `getUser not emitting same value`() = runTest {
        val expectedEntityUser1 = userLocalTestUtil.createDbUser(expectedUserId, expectedUserLogin)
        val expectedDomainUser1 = userLocalTestUtil.createDomainModel(expectedEntityUser1)
        val expectedDomainUser2 = userLocalTestUtil.createDomainModel(expectedEntityUser1)
        coEvery { userDao.getByLogin(any()) } returns flowOf(
            expectedEntityUser1,
            expectedEntityUser1
        )
        every { userLocalMapper.userToDomain(any()) } returnsMany listOf(
            expectedDomainUser1,
            expectedDomainUser2
        )

        sut.getUser(expectedUserLogin).test {
            val firsValueEmitted = awaitItem()
            assertNotNull(firsValueEmitted)
            assertEquals(expectedDomainUser1.id, firsValueEmitted!!.id)
            assertEquals(expectedDomainUser1.login, firsValueEmitted.login)
            awaitComplete()
        }
        // Behavior verification
        verify(exactly = 1) {
            userDao.getByLogin(any())
            userLocalMapper.userToDomain(any())
        }
        verifySequence {
            userDao.getByLogin(any())
            userLocalMapper.userToDomain(any())
        }
    }

    @Test
    fun `getUser changed`() = runTest {
        val expectedEntityUser1 = userLocalTestUtil.createDbUser(expectedUserId, expectedUserLogin)
        val expectedEntityUser2 = expectedEntityUser1.copy(login = "expectedEntityUser2", id = 567)
        val expectedDomainUser1 = userLocalTestUtil.createDomainModel(expectedEntityUser1)
        val expectedDomainUser2 = userLocalTestUtil.createDomainModel(expectedEntityUser2)
        coEvery { userDao.getByLogin(any()) } returns flowOf(
            expectedEntityUser1,
            expectedEntityUser2
        )
        every { userLocalMapper.userToDomain(any()) } returnsMany listOf(
            expectedDomainUser1,
            expectedDomainUser2
        )

        sut.getUser(expectedUserLogin).test {
            val firsValueEmitted = awaitItem()
            assertNotNull(firsValueEmitted)
            assertEquals(expectedDomainUser1.id, firsValueEmitted!!.id)
            assertEquals(expectedDomainUser1.login, firsValueEmitted.login)
            val secondValueEmitted = awaitItem()
            assertNotNull(firsValueEmitted)
            assertEquals(expectedDomainUser2.id, secondValueEmitted!!.id)
            assertEquals(expectedDomainUser2.login, secondValueEmitted.login)
            awaitComplete()
        }
        // Behavior verification
        verify(exactly = 1) {
            userDao.getByLogin(any())
        }
        verify(exactly = 2) {
            userLocalMapper.userToDomain(any())
        }
        verifySequence {
            userDao.getByLogin(any())
            userLocalMapper.userToDomain(any())
            userLocalMapper.userToDomain(any())
        }
    }

    @Test
    fun `getUser empty dao answer`() = runTest {
        coEvery { userDao.getByLogin(any()) } returns flow { emit(null) }

        sut.getUser(expectedUserLogin).test {
            assertNull(awaitItem())
            awaitComplete()
        }
    }

    @Test
    fun saveUser() = runTest {
        val expectedEntityUser = userLocalTestUtil.createDbUser(expectedUserId, expectedUserLogin)
        val expectedDomainUser = userLocalTestUtil.createDomainModel(expectedEntityUser)
        coEvery { userDao.insert(any()) } returns Unit
        every { userLocalMapper.userToLocal(any()) } returns expectedEntityUser

        sut.saveUser(expectedDomainUser)

        coVerify(exactly = 1) {
            userLocalMapper.userToLocal(any())
            userDao.insert(any())
        }
        coVerifySequence {
            userLocalMapper.userToLocal(any())
            userDao.insert(any())
        }
    }
}
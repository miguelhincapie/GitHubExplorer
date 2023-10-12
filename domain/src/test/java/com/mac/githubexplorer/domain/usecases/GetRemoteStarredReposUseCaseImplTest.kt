package com.mac.githubexplorer.domain.usecases

import com.mac.githubexplorer.domain.model.Repo
import com.mac.githubexplorer.domain.repo.RepoRepository
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class GetRemoteStarredReposUseCaseImplTest {

    @MockK
    lateinit var repoRepository: RepoRepository

    private lateinit var sut: GetRemoteStarredReposUseCaseImpl

    @BeforeEach
    fun setUp() {
        sut = GetRemoteStarredReposUseCaseImpl(repoRepository)
        every { repoRepository.getStarredRepos(any()) } returns flow {
            emit(dummyRepos)
        }
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `call repo once and emit values`() = runTest {
        assertEquals(1, sut.invoke("").count())

        verify(atMost = 1) {
            repoRepository.getStarredRepos(any())
        }
    }

    @Test
    fun `check repos returned in flow`() = runTest {
        sut.invoke("").collect {
            assertEquals(dummyRepos, it)
        }
    }

    @Test
    fun `check correct completion`() = runTest {
        sut.invoke("").onCompletion {
            assertEquals(null, it)
        }.collect()
    }


    companion object {
        private val dummyRepos = listOf(
            Repo(
                id = 1,
                name = "",
                fullName = "",
                private = false,
                htmlUrl = "",
                description = "",
                url = "",
                language = "",
                stargazersCount = 0,
                homepage = "",
                license = null,
                topics = listOf(),
                forks = 0,
                ownerLogin = ""
            ),
            Repo(
                id = 2,
                name = "",
                fullName = "",
                private = false,
                htmlUrl = "",
                description = "",
                url = "",
                language = "",
                stargazersCount = 0,
                homepage = "",
                license = null,
                topics = listOf(),
                forks = 0,
                ownerLogin = ""
            )
        )
    }
}
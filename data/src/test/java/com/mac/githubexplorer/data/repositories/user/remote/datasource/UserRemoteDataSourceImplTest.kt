package com.mac.githubexplorer.data.repositories.user.remote.datasource

import com.mac.githubexplorer.data.repositories.commons.remote.api.GitHubReposService
import com.mac.githubexplorer.data.repositories.user.remote.UserRemoteTestUtil
import com.mac.githubexplorer.data.repositories.user.remote.dto.UserDTO
import com.mac.githubexplorer.data.repositories.user.remote.mapper.UserRemoteMapper
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import retrofit2.Response

@ExtendWith(MockKExtension::class)
class UserRemoteDataSourceImplTest {

    @MockK
    lateinit var gitHubReposService: GitHubReposService

    @MockK
    lateinit var userRemoteMapper: UserRemoteMapper

    private val userRemoteTestUtil = UserRemoteTestUtil()
    private val expectedName = "expectedName1"
    private val expectedId = 1234

    private lateinit var sut: UserRemoteDataSource

    @BeforeEach
    fun setUp() {
        sut = UserRemoteDataSourceImpl(gitHubReposService, userRemoteMapper)
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `get user success remote answer`() = runTest {
        val expectedResponse = userRemoteTestUtil.createDTOUser(expectedName, expectedId).let {
            Response.success(it)
        }
        val expectedDTO = expectedResponse.body()!!
        coEvery { gitHubReposService.getUser(any()) } returns expectedResponse
        val expectedDomainModel = userRemoteTestUtil.createDomainUser(expectedDTO)
        every { userRemoteMapper.userToDomain(any()) } returns expectedDomainModel

        val domainModel = sut.getUser(expectedName)

        assertNotNull(domainModel)
        assertEquals(expectedDTO.id, domainModel!!.id)
        assertEquals(expectedDTO.login, domainModel.login)
    }

    @Test
    fun `get user error remote answer`() = runTest {
        val expectedResponse = Response.error<UserDTO>(
            401,
            ByteArray(0).toResponseBody("application/json".toMediaTypeOrNull())
        )
        coEvery { gitHubReposService.getUser(any()) } returns expectedResponse

        val nullDomainValue = sut.getUser(expectedName)

        assertNull(nullDomainValue)
    }
}
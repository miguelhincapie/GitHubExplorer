package com.mac.githubexplorer.data.repositories.user.remote.mapper

import com.mac.githubexplorer.data.repositories.user.remote.UserRemoteTestUtil
import io.mockk.clearAllMocks
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class UserRemoteMapperTest {

    private val userRemoteTestUtil = UserRemoteTestUtil()
    private lateinit var sut: UserRemoteMapper

    @BeforeEach
    fun setUp() {
        sut = UserRemoteMapper()
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun userToDomain() {
        val expectedName = "expectedName1"
        val expectedId = 1234
        val expectedDomainModel = userRemoteTestUtil.createDTOUser(expectedName, expectedId)

        val dto = userRemoteTestUtil.createDTOUser(expectedName, expectedId)
        val resultDomainModel = sut.userToDomain(dto)

        assertNotNull(resultDomainModel)
        assertEquals(expectedDomainModel.id, resultDomainModel.id)
        assertEquals(expectedDomainModel.login, resultDomainModel.login)
    }
}
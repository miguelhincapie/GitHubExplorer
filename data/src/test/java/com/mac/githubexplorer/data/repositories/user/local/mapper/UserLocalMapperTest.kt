package com.mac.githubexplorer.data.repositories.user.local.mapper

import com.mac.githubexplorer.data.repositories.user.local.UserLocalTestUtil
import io.mockk.clearAllMocks
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class UserLocalMapperTest {

    private val userLocalTestUtil = UserLocalTestUtil()
    private val expectedName = "expectedName1"
    private val expectedId = 1234

    private lateinit var sut: UserLocalMapper

    @BeforeEach
    fun setUp() {
        sut = UserLocalMapper()
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun userToDomain() {
        val entity = userLocalTestUtil.createDbUser(expectedId, expectedName)
        val expectedDomainModel = userLocalTestUtil.createDomainModel(entity)

        val resultDomainModel = sut.userToDomain(entity)

        assertEquals(expectedDomainModel.id, resultDomainModel.id)
        assertEquals(expectedDomainModel.login, resultDomainModel.login)
    }

    @Test
    fun userToLocal() {
        val entity = userLocalTestUtil.createDbUser(expectedId, expectedName)
        val expectedDomainModel = userLocalTestUtil.createDomainModel(entity)

        val resultDomainModel = sut.userToLocal(expectedDomainModel)

        assertEquals(entity.id, resultDomainModel.id)
        assertEquals(entity.login, resultDomainModel.login)
    }
}
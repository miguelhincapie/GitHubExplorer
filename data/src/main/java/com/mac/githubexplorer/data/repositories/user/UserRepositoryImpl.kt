package com.mac.githubexplorer.data.repositories.user

import com.mac.githubexplorer.data.repositories.user.remote.datasources.UserRemoteDataSource
import com.mac.githubexplorer.domain.model.User
import com.mac.githubexplorer.domain.repo.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {
    override fun getUser(userName: String): Flow<User?> {
        return flow { emit(userRemoteDataSource.getUser(userName)) }
    }
}
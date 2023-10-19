package com.mac.githubexplorer.data.repositories.user

import com.mac.githubexplorer.data.repositories.user.local.datasource.UserLocalDataSource
import com.mac.githubexplorer.data.repositories.user.remote.datasource.UserRemoteDataSource
import com.mac.githubexplorer.domain.di.IoDispatcher
import com.mac.githubexplorer.domain.model.User
import com.mac.githubexplorer.domain.repo.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource,
    private val localDataSource: UserLocalDataSource,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : UserRepository {
    override fun getUser(userName: String): Flow<User?> {
        // got remote, save in local, expose local, run app and test
        return flow { emit(remoteDataSource.getUser(userName)) }.flowOn(dispatcher)
    }
}
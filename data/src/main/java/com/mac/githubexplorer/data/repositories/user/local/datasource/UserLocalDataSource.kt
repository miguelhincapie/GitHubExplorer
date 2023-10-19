package com.mac.githubexplorer.data.repositories.user.local.datasource

import com.mac.githubexplorer.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {
    suspend fun loadUser(userName: String): User?
    fun getUser(userName: String): Flow<User?>
    suspend fun saveUser(user: User)
}
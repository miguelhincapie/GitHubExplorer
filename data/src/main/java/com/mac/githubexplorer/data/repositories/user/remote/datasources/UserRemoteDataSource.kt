package com.mac.githubexplorer.data.repositories.user.remote.datasources

import com.mac.githubexplorer.domain.model.User

interface UserRemoteDataSource {
    suspend fun getUser(userName: String): User?
}
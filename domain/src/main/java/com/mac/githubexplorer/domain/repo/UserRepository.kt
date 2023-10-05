package com.mac.githubexplorer.domain.repo

import com.mac.githubexplorer.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(userName: String): Flow<User?>
}
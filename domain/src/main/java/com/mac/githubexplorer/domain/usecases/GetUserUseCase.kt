package com.mac.githubexplorer.domain.usecases

import com.mac.githubexplorer.domain.model.User
import kotlinx.coroutines.flow.Flow

interface GetUserUseCase {
    operator fun invoke(userName: String): Flow<User?>
}
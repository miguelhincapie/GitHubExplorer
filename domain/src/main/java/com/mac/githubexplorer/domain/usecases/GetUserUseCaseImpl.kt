package com.mac.githubexplorer.domain.usecases

import com.mac.githubexplorer.domain.model.User
import com.mac.githubexplorer.domain.repo.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : GetUserUseCase {

    override operator fun invoke(userName: String): Flow<User?> {
        return userRepository.getUser(userName)
    }
}
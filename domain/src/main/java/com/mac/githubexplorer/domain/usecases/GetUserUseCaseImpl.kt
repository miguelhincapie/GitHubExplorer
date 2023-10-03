package com.mac.githubexplorer.domain.usecases

import com.mac.githubexplorer.domain.model.User
import com.mac.githubexplorer.domain.repo.GitHubReposRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserUseCaseImpl @Inject constructor(
    private val gitHubRepository: GitHubReposRepository
) : GetUserUseCase {

    override operator fun invoke(userName: String): Flow<User?> {
        return gitHubRepository.getUser(userName)
    }
}
package com.mac.githubexplorer.domain.usecases

import com.mac.githubexplorer.domain.model.Repo
import com.mac.githubexplorer.domain.repo.GitHubReposRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRemoteStarredReposUseCaseImpl @Inject constructor(
    private val gitHubRepository: GitHubReposRepository
) : GetRemoteStarredReposUseCase {

    override operator fun invoke(userName: String): Flow<List<Repo>?> {
        return gitHubRepository.getStarredRepos(userName)
    }
}
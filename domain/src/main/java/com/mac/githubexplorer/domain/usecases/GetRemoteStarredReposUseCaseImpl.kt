package com.mac.githubexplorer.domain.usecases

import com.mac.githubexplorer.domain.model.Repo
import com.mac.githubexplorer.domain.repo.RepoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRemoteStarredReposUseCaseImpl @Inject constructor(
    private val repoRepository: RepoRepository
) : GetRemoteStarredReposUseCase {

    override operator fun invoke(userId: String): Flow<List<Repo>?> {
        return repoRepository.getStarredRepos(userId)
    }
}
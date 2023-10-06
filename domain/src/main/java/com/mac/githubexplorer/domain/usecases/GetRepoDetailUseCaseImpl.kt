package com.mac.githubexplorer.domain.usecases

import com.mac.githubexplorer.domain.model.Repo
import com.mac.githubexplorer.domain.repo.RepoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRepoDetailUseCaseImpl @Inject constructor(
    private val repoRepository: RepoRepository
) : GetRepoDetailUseCase {

    override fun invoke(userId: String, repoId: String): Flow<Repo?> {
        return repoRepository.getRepoDetail(userId, repoId)
    }
}
package com.mac.githubexplorer.data.repositories

import com.mac.githubexplorer.data.repositories.remote.GitHubRemoteDataSource
import com.mac.githubexplorer.domain.model.Repo
import com.mac.githubexplorer.domain.repo.GitHubReposRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GitHubReposRepositoryImpl @Inject constructor(
    private val gitHubDataSource: GitHubRemoteDataSource
) : GitHubReposRepository {
    override fun getStarredRepos(userName: String): Flow<List<Repo>?> {
        return gitHubDataSource.getStarredRepos(userName)
    }
}
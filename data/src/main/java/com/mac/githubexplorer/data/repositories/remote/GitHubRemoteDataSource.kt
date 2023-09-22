package com.mac.githubexplorer.data.repositories.remote

import com.mac.githubexplorer.data.repositories.datasources.RemoteDataSource
import com.mac.githubexplorer.data.repositories.remote.api.GitHubReposService
import com.mac.githubexplorer.domain.model.Repo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GitHubRemoteDataSource @Inject constructor(
    private val gitHubReposService: GitHubReposService
) : RemoteDataSource {
    override fun getStarredRepos(userName: String): Flow<List<Repo>?> {
        return flow {
            emit(gitHubReposService.getStarredRepositories(userName).body())
        }
    }
}
package com.mac.githubexplorer.data.repositories.remote

import com.mac.githubexplorer.data.repositories.datasources.RemoteDataSource
import com.mac.githubexplorer.data.repositories.mapper.toDomain
import com.mac.githubexplorer.data.repositories.remote.api.GitHubReposService
import com.mac.githubexplorer.domain.model.Repo
import com.mac.githubexplorer.domain.model.User
import javax.inject.Inject

class GitHubRemoteDataSource @Inject constructor(
    private val gitHubReposService: GitHubReposService
) : RemoteDataSource {
    override suspend fun getUser(userName: String): User? {
        return gitHubReposService.getUser(userName).body()?.toDomain()
    }

    override suspend fun getStarredRepos(userName: String): List<Repo>? {
        return gitHubReposService.getStarredRepositories(userName).body()?.map {
            it.toDomain()
        }
    }
}
package com.mac.githubexplorer.data.repositories.user.remote.datasources

import com.mac.githubexplorer.data.repositories.commons.remote.api.GitHubReposService
import com.mac.githubexplorer.data.repositories.user.mapper.toDomain
import com.mac.githubexplorer.domain.model.User
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(
    private val gitHubReposService: GitHubReposService
) : UserRemoteDataSource {
    override suspend fun getUser(userName: String): User? {
        return gitHubReposService.getUser(userName).body()?.toDomain()
    }
}
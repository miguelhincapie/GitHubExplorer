package com.mac.githubexplorer.data.repositories.user.remote.datasource

import com.mac.githubexplorer.data.repositories.commons.remote.api.GitHubReposService
import com.mac.githubexplorer.data.repositories.user.remote.mapper.UserRemoteMapper
import com.mac.githubexplorer.domain.model.User
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(
    private val gitHubReposService: GitHubReposService,
    private val userRemoteMapper: UserRemoteMapper
) : UserRemoteDataSource {
    override suspend fun getUser(userName: String): User? {
        return gitHubReposService.getUser(userName).body()?.let {
            userRemoteMapper.userToDomain(it)
        }
    }
}
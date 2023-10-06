package com.mac.githubexplorer.data.repositories.repo.remote.datasources

import com.mac.githubexplorer.data.repositories.commons.remote.api.GitHubReposService
import com.mac.githubexplorer.data.repositories.repo.mapper.toDomain
import com.mac.githubexplorer.domain.model.Repo
import javax.inject.Inject

class RepoRemoteDataSourceImpl @Inject constructor(
    private val gitHubReposService: GitHubReposService
) : RepoRemoteDataSource {

    override suspend fun getStarredRepos(userName: String): List<Repo>? {
        return gitHubReposService.getStarredRepositories(userName).body()?.map {
            it.toDomain()
        }
    }

    override suspend fun getRepoDetail(userId: String, repoId: String): Repo? {
        return gitHubReposService.getRepoDetail(userId, repoId).body()?.toDomain()
    }
}
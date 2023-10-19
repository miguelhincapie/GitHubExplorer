package com.mac.githubexplorer.data.repositories.repo.remote.datasource

import com.mac.githubexplorer.data.repositories.commons.remote.api.GitHubReposService
import com.mac.githubexplorer.data.repositories.repo.remote.mapper.RepoRemoteMapper
import com.mac.githubexplorer.domain.model.Repo
import javax.inject.Inject

class RepoRemoteDataSourceImpl @Inject constructor(
    private val gitHubReposService: GitHubReposService,
    private val repoRemoteMapper: RepoRemoteMapper
) : RepoRemoteDataSource {

    override suspend fun getStarredRepos(userName: String): List<Repo>? {
        return gitHubReposService.getStarredRepositories(userName).body()?.map {
            repoRemoteMapper.repoToDomain(it)
        }
    }

    override suspend fun getRepoDetail(userId: String, repoId: String): Repo? {
        return gitHubReposService.getRepoDetail(userId, repoId).body()?.let {
            repoRemoteMapper.repoToDomain(it)
        }
    }
}
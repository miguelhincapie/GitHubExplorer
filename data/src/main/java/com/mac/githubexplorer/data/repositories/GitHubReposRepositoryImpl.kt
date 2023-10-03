package com.mac.githubexplorer.data.repositories

import com.mac.githubexplorer.data.repositories.remote.GitHubRemoteDataSource
import com.mac.githubexplorer.domain.model.Repo
import com.mac.githubexplorer.domain.model.User
import com.mac.githubexplorer.domain.repo.GitHubReposRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GitHubReposRepositoryImpl @Inject constructor(
    private val gitHubDataSource: GitHubRemoteDataSource
) : GitHubReposRepository {
    override fun getUser(userName: String): Flow<User?> {
        return flow { emit(gitHubDataSource.getUser(userName)) }
    }

    override fun getStarredRepos(userName: String): Flow<List<Repo>?> {
        return flow { emit(gitHubDataSource.getStarredRepos(userName)) }
    }
}
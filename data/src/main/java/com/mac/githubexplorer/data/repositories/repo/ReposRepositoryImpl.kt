package com.mac.githubexplorer.data.repositories.repo

import com.mac.githubexplorer.data.repositories.repo.remote.datasources.RepoRemoteDataSource
import com.mac.githubexplorer.domain.model.Repo
import com.mac.githubexplorer.domain.repo.ReposRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ReposRepositoryImpl @Inject constructor(
    private val gitHubDataSource: RepoRemoteDataSource
) : ReposRepository {

    override fun getStarredRepos(userName: String): Flow<List<Repo>?> {
        return flow { emit(gitHubDataSource.getStarredRepos(userName)) }
    }
}
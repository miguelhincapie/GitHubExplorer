package com.mac.githubexplorer.data.repositories.repo

import com.mac.githubexplorer.data.repositories.repo.remote.datasources.RepoRemoteDataSource
import com.mac.githubexplorer.domain.model.Repo
import com.mac.githubexplorer.domain.repo.RepoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepoRepositoryImpl @Inject constructor(
    private val remoteDataSource: RepoRemoteDataSource
) : RepoRepository {

    override fun getStarredRepos(userId: String): Flow<List<Repo>?> {
        return flow { emit(remoteDataSource.getStarredRepos(userId)) }
    }

    override fun getRepoDetail(userId: String, repoId: String): Flow<Repo?> {
        return flow { emit(remoteDataSource.getRepoDetail(userId, repoId)) }
    }
}
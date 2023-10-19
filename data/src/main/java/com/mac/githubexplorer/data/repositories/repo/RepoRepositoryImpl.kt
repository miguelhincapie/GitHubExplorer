package com.mac.githubexplorer.data.repositories.repo

import com.mac.githubexplorer.data.repositories.repo.local.datasource.RepoLocalDataSource
import com.mac.githubexplorer.data.repositories.repo.remote.datasource.RepoRemoteDataSource
import com.mac.githubexplorer.domain.di.IoDispatcher
import com.mac.githubexplorer.domain.model.Repo
import com.mac.githubexplorer.domain.repo.RepoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepoRepositoryImpl @Inject constructor(
    private val remoteDataSource: RepoRemoteDataSource,
    private val localDataSource: RepoLocalDataSource,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : RepoRepository {

    override fun getStarredRepos(userId: String): Flow<List<Repo>?> {
        return flow { emit(remoteDataSource.getStarredRepos(userId)) }.flowOn(dispatcher)
    }

    override fun getRepoDetail(userId: String, repoId: String): Flow<Repo?> {
        return flow { emit(remoteDataSource.getRepoDetail(userId, repoId)) }.flowOn(dispatcher)
    }
}
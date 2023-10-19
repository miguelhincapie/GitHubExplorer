package com.mac.githubexplorer.data.repositories.repo.local.datasource

import com.mac.githubexplorer.data.repositories.repo.local.datasource.dao.RepoDao
import com.mac.githubexplorer.data.repositories.repo.local.mapper.RepoLocalMapper
import com.mac.githubexplorer.domain.model.Repo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepoLocalDataSourceImpl @Inject constructor(
    private val repoDao: RepoDao,
    private val repoLocalMapper: RepoLocalMapper
) : RepoLocalDataSource {
    override suspend fun loadRepo(repoName: String): Repo? {
        TODO("Not yet implemented")
    }

    override fun getRepo(repoName: String): Flow<Repo?> {
        TODO("Not yet implemented")
    }

    override suspend fun saveRepo(repo: Repo) {
        TODO("Not yet implemented")
    }
}
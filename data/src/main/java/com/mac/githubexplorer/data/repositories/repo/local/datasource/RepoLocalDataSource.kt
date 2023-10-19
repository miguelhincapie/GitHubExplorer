package com.mac.githubexplorer.data.repositories.repo.local.datasource

import com.mac.githubexplorer.domain.model.Repo
import kotlinx.coroutines.flow.Flow

interface RepoLocalDataSource {

    suspend fun loadRepo(repoName: String): Repo?
    fun getRepo(repoName: String): Flow<Repo?>
    suspend fun saveRepo(repo: Repo)
}
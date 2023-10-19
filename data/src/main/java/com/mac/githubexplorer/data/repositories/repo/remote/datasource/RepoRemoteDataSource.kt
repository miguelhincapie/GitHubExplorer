package com.mac.githubexplorer.data.repositories.repo.remote.datasource

import com.mac.githubexplorer.domain.model.Repo

interface RepoRemoteDataSource {
    suspend fun getStarredRepos(userName: String): List<Repo>?
    suspend fun getRepoDetail(userId: String, repoId: String): Repo?
}
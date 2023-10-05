package com.mac.githubexplorer.data.repositories.repo.remote.datasources

import com.mac.githubexplorer.domain.model.Repo

interface RepoRemoteDataSource {
    suspend fun getStarredRepos(userName: String): List<Repo>?
}
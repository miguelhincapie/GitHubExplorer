package com.mac.githubexplorer.data.repositories.datasources

import com.mac.githubexplorer.domain.model.Repo
import com.mac.githubexplorer.domain.model.User

interface RemoteDataSource {
    suspend fun getUser(userName: String): User?
    suspend fun getStarredRepos(userName: String): List<Repo>?
}
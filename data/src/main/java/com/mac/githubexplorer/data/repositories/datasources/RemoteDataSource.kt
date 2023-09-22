package com.mac.githubexplorer.data.repositories.datasources

import com.mac.githubexplorer.domain.model.Repo
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getStarredRepos(userName: String): Flow<List<Repo>?>
}
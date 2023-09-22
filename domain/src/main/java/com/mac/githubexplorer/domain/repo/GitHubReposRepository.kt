package com.mac.githubexplorer.domain.repo

import com.mac.githubexplorer.domain.model.Repo
import kotlinx.coroutines.flow.Flow

interface GitHubReposRepository {
    fun getStarredRepos(userName: String): Flow<List<Repo>?>
}
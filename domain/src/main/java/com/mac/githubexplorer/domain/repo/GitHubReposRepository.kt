package com.mac.githubexplorer.domain.repo

import com.mac.githubexplorer.domain.model.Repo
import com.mac.githubexplorer.domain.model.User
import kotlinx.coroutines.flow.Flow

interface GitHubReposRepository {
    fun getUser(userName: String): Flow<User?>
    fun getStarredRepos(userName: String): Flow<List<Repo>?>
}
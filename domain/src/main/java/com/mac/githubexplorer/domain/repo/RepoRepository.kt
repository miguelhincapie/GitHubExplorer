package com.mac.githubexplorer.domain.repo

import com.mac.githubexplorer.domain.model.Repo
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    fun getStarredRepos(userId: String): Flow<List<Repo>?>
    fun getRepoDetail(userId: String, repoId: String): Flow<Repo?>
}
package com.mac.githubexplorer.data.repositories.repo.local.mapper

import com.mac.githubexplorer.data.repositories.repo.local.entity.RepoAndTopics
import com.mac.githubexplorer.domain.model.Repo
import javax.inject.Inject

class RepoLocalMapper @Inject constructor() {

    fun repoToDomain(repoEntity: RepoAndTopics): Repo = with(repoEntity) {
        TODO()
    }

    fun repoToLocal(repo: Repo): RepoAndTopics = with(repo) {
        TODO()
    }
}
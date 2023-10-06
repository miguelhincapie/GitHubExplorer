package com.mac.githubexplorer.domain.usecases

import com.mac.githubexplorer.domain.model.Repo
import kotlinx.coroutines.flow.Flow

interface GetRepoDetailUseCase {
    operator fun invoke(
        userId: String,
        repoId: String
    ): Flow<Repo?>
}
package com.mac.githubexplorer.domain.usecases

import com.mac.githubexplorer.domain.model.Repo
import kotlinx.coroutines.flow.Flow

interface GetRemoteStarredReposUseCase {
    operator fun invoke(userName: String): Flow<List<Repo>?>
}
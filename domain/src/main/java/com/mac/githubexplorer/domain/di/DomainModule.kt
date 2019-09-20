package com.mac.githubexplorer.domain.di

import android.util.Log
import com.mac.githubexplorer.domain.repositories.GitHubReposRepository
import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class DomainModule {

    private val TAG = "dagger-DomainModule"

    @Reusable
    @Provides
    fun provideGetRemoteStarredReposUseCase(gitHubReposRepository: GitHubReposRepository): GetRemoteStarredReposUseCase {
        Log.d(TAG, "creando GetRemoteStarredReposUseCase")
        return GetRemoteStarredReposUseCase(gitHubReposRepository)
    }
}
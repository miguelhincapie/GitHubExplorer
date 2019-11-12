package com.mac.githubexplorer.domain.di

import android.util.Log
import com.mac.githubexplorer.domain.interfaces.FeedRepository
import com.mac.githubexplorer.domain.interfaces.GitHubReposRepository
import com.mac.githubexplorer.domain.usecases.GetFeedListUseCase
import com.mac.githubexplorer.domain.usecases.GetGitHubRepositoryDetailUseCase
import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetRemoteStarredReposUseCase(gitHubReposRepository: GitHubReposRepository): GetRemoteStarredReposUseCase {
        Log.d(TAG, "creating an instance of GetRemoteStarredReposUseCase")
        return GetRemoteStarredReposUseCase(gitHubReposRepository)
    }

    @Provides
    fun provideGetGitHubRepositoryDetailUseCase(gitHubReposRepository: GitHubReposRepository): GetGitHubRepositoryDetailUseCase {
        Log.d(TAG, "creating an instance of GetGitHubRepositoryDetailUseCase")
        return GetGitHubRepositoryDetailUseCase(gitHubReposRepository)
    }

    @Provides
    fun provideFeedListUseCase(feedRepository: FeedRepository): GetFeedListUseCase {
        return GetFeedListUseCase(feedRepository)
    }

    companion object {
        private const val TAG = "dagger-DomainModule"
    }
}
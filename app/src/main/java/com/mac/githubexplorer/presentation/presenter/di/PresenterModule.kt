package com.mac.githubexplorer.presentation.presenter.di

import android.util.Log
import com.mac.githubexplorer.domain.usecases.GetFeedListUseCase
import com.mac.githubexplorer.domain.usecases.GetGitHubRepositoryDetailUseCase
import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase
import com.mac.githubexplorer.presentation.presenter.viewmodel.FeedListViewModelFactory
import com.mac.githubexplorer.presentation.presenter.viewmodel.ReposViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun provideViewModelFactory(
        getRemoteStarredReposUseCase: GetRemoteStarredReposUseCase,
        getGitHubRepositoryDetailUseCase: GetGitHubRepositoryDetailUseCase
    ): ReposViewModelFactory {
        Log.d(TAG, "creating an instance of ReposViewModelFactory")
        return ReposViewModelFactory(getRemoteStarredReposUseCase, getGitHubRepositoryDetailUseCase)
    }

    @Provides
    fun provideFeedViewModelFactory(getFeedListUseCase: GetFeedListUseCase): FeedListViewModelFactory {
        return FeedListViewModelFactory(getFeedListUseCase)
    }

    companion object {
        private const val TAG = "dagger-Presentation"
    }
}

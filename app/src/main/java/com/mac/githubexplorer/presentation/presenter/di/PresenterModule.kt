package com.mac.githubexplorer.presentation.presenter.di

import com.mac.githubexplorer.domain.usecases.GetFeedListUseCase
import com.mac.githubexplorer.presentation.presenter.viewmodel.FeedListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun provideFeedViewModelFactory(getFeedListUseCase: GetFeedListUseCase): FeedListViewModelFactory {
        return FeedListViewModelFactory(getFeedListUseCase)
    }
}

package com.mac.githubexplorer.domain.di

import com.mac.githubexplorer.domain.interfaces.FeedRepository
import com.mac.githubexplorer.domain.usecases.GetFeedListUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideFeedListUseCase(feedRepository: FeedRepository): GetFeedListUseCase {
        return GetFeedListUseCase(feedRepository)
    }
}
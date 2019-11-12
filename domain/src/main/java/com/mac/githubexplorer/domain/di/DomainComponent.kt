package com.mac.githubexplorer.domain.di

import com.mac.githubexplorer.domain.interfaces.FeedRepository
import com.mac.githubexplorer.domain.usecases.GetFeedListUseCase
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DomainModule::class])
interface DomainComponent {

    @Component.Factory
    interface Factory {
        fun build(@BindsInstance feedRepository: FeedRepository): DomainComponent
    }

    fun provideGetFeedListUseCase(): GetFeedListUseCase
}
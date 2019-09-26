package com.mac.githubexplorer.domain.di

import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase
import dagger.Subcomponent

@DomainScope
@Subcomponent(modules = [DomainModule::class])
interface DomainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun build(): DomainComponent
    }

    fun provideGetRemoteStarredReposUseCase(): GetRemoteStarredReposUseCase
}
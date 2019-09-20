package com.mac.githubexplorer.domain.di

import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase
import dagger.BindsInstance
import dagger.Subcomponent

@DomainScope
@Subcomponent(modules = [DomainModule::class])
interface DomainComponent {

    @Subcomponent.Builder
    interface Builder {
//        @BindsInstance
//        fun domainModule(domainModule: DomainModule): Builder

        fun build(): DomainComponent
    }

    fun provideGetRemoteStarredReposUseCase(): GetRemoteStarredReposUseCase
}
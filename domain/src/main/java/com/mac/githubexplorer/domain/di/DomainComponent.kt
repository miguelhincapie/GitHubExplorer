package com.mac.githubexplorer.domain.di

import com.mac.githubexplorer.domain.interfaces.GitHubReposRepository
import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DomainModule::class])
interface DomainComponent {

    @Component.Factory
    interface Factory {
        fun build(@BindsInstance gitHubReposRepository: GitHubReposRepository): DomainComponent
    }

    fun provideGetRemoteStarredReposUseCase(): GetRemoteStarredReposUseCase
}
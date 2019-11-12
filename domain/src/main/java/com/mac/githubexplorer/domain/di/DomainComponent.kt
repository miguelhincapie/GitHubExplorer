package com.mac.githubexplorer.domain.di

import com.mac.githubexplorer.domain.interfaces.FeedRepository
import com.mac.githubexplorer.domain.interfaces.GitHubReposRepository
import com.mac.githubexplorer.domain.usecases.GetFeedListUseCase
import com.mac.githubexplorer.domain.usecases.GetGitHubRepositoryDetailUseCase
import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DomainModule::class])
interface DomainComponent {

    @Component.Factory
    interface Factory {
        fun build(@BindsInstance gitHubReposRepository: GitHubReposRepository, @BindsInstance feedRepository: FeedRepository): DomainComponent
    }

    fun provideGetRemoteStarredReposUseCase(): GetRemoteStarredReposUseCase
    fun provideGetGitHubRepositoryDetailUseCase(): GetGitHubRepositoryDetailUseCase
    fun provideGetFeedListUseCase(): GetFeedListUseCase
}
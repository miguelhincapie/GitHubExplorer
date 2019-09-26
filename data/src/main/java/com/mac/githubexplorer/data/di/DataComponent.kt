package com.mac.githubexplorer.data.di

import com.mac.githubexplorer.domain.di.DomainComponent
import com.mac.githubexplorer.domain.repositories.GitHubReposRepository
import dagger.Subcomponent

@DataScope
@Subcomponent(modules = [DataModule::class])
interface DataComponent {

    @Subcomponent.Factory
    interface Factory {
//        fun create(dataModule: DataModule): DataComponent
        fun build(): DataComponent
    }

    fun provideGitHubReposRepository(): GitHubReposRepository

    fun plusDomainComponent(): DomainComponent.Factory
}
package com.mac.githubexplorer.data.di

import com.mac.githubexplorer.domain.di.DomainComponent
import com.mac.githubexplorer.domain.repositories.GitHubReposRepository
import dagger.BindsInstance
import dagger.Subcomponent

@DataScope
@Subcomponent(modules = [DataModule::class])
interface DataComponent {

    @Subcomponent.Builder
    interface Builder {
//        @BindsInstance
//        fun dataModule(dataModule: DataModule): Builder

        fun build(): DataComponent
    }

    fun provideGitHubReposRepository(): GitHubReposRepository

    fun plusDomainComponent(): DomainComponent.Builder
}
package com.mac.githubexplorer.data.di

import com.mac.githubexplorer.domain.repositories.GitHubReposRepository
import dagger.Component

@DataScope
@Component(modules = [DataModule::class])
interface DataComponent {

    @Component.Factory
    interface Factory {
        fun build(): DataComponent
    }

    fun provideGitHubReposRepository(): GitHubReposRepository
}
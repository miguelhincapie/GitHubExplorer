package com.mac.githubexplorer.data.di

import com.mac.githubexplorer.data.image.GlideImpl
import com.mac.githubexplorer.data.repositories.GitHubReposRepositoryImpl
import com.mac.githubexplorer.data.repositories.datasources.RemoteDataSource
import com.mac.githubexplorer.data.repositories.remote.GitHubRemoteDataSource
import com.mac.githubexplorer.domain.image.ImageFramework
import com.mac.githubexplorer.domain.repo.GitHubReposRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModuleBinds {

    @RemoteDataSourceQualifier
    @Binds
    abstract fun bindRepoRemoteDataSource(gitHubRemoteDataSource: GitHubRemoteDataSource): RemoteDataSource

    @Binds
    abstract fun bindGitHubRepoRepository(gitHubReposRepository: GitHubReposRepositoryImpl): GitHubReposRepository

    @Binds
    abstract fun bindImageFramework(glideImpl: GlideImpl): ImageFramework
}

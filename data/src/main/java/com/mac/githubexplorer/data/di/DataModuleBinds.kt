package com.mac.githubexplorer.data.di

import com.mac.githubexplorer.data.image.GlideImpl
import com.mac.githubexplorer.data.repositories.repo.RepoRepositoryImpl
import com.mac.githubexplorer.data.repositories.repo.local.datasource.RepoLocalDataSource
import com.mac.githubexplorer.data.repositories.repo.local.datasource.RepoLocalDataSourceImpl
import com.mac.githubexplorer.data.repositories.repo.remote.datasource.RepoRemoteDataSource
import com.mac.githubexplorer.data.repositories.repo.remote.datasource.RepoRemoteDataSourceImpl
import com.mac.githubexplorer.data.repositories.user.UserRepositoryImpl
import com.mac.githubexplorer.data.repositories.user.local.datasource.UserLocalDataSource
import com.mac.githubexplorer.data.repositories.user.local.datasource.UserLocalDataSourceImpl
import com.mac.githubexplorer.data.repositories.user.remote.datasource.UserRemoteDataSource
import com.mac.githubexplorer.data.repositories.user.remote.datasource.UserRemoteDataSourceImpl
import com.mac.githubexplorer.domain.image.ImageFramework
import com.mac.githubexplorer.domain.repo.RepoRepository
import com.mac.githubexplorer.domain.repo.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModuleBinds {

    //region RepoRepository
    @Binds
    abstract fun bindRepoRemoteDataSource(repoRemoteDataSource: RepoRemoteDataSourceImpl): RepoRemoteDataSource

    @Binds
    abstract fun bindRepoRepository(reposRepository: RepoRepositoryImpl): RepoRepository
    //endregion

    //region UserRepository
    @Binds
    abstract fun bindUserRemoteDataSource(userRemoteDataSource: UserRemoteDataSourceImpl): UserRemoteDataSource

    @Binds
    abstract fun bindUserRepository(userRepository: UserRepositoryImpl): UserRepository
    //endregion

    @Binds
    abstract fun bindImageFramework(imageFramework: GlideImpl): ImageFramework

    @Binds
    abstract fun bindUserLocalDataSource(userLocalDataSource: UserLocalDataSourceImpl): UserLocalDataSource

    @Binds
    abstract fun bindRepoLocalDataSource(repoLocalDataSource: RepoLocalDataSourceImpl): RepoLocalDataSource
}

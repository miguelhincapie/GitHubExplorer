package com.mac.githubexplorer.data.di

import com.mac.githubexplorer.data.image.GlideImpl
import com.mac.githubexplorer.data.repositories.repo.ReposRepositoryImpl
import com.mac.githubexplorer.data.repositories.repo.remote.datasources.RepoRemoteDataSource
import com.mac.githubexplorer.data.repositories.repo.remote.datasources.RepoRemoteDataSourceImpl
import com.mac.githubexplorer.data.repositories.user.UserRepositoryImpl
import com.mac.githubexplorer.data.repositories.user.remote.datasources.UserRemoteDataSource
import com.mac.githubexplorer.data.repositories.user.remote.datasources.UserRemoteDataSourceImpl
import com.mac.githubexplorer.domain.image.ImageFramework
import com.mac.githubexplorer.domain.repo.ReposRepository
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
    abstract fun bindRepoRepository(reposRepository: ReposRepositoryImpl): ReposRepository
    //endregion

    //region UserRepository
    @Binds
    abstract fun bindUserRemoteDataSource(userRemoteDataSource: UserRemoteDataSourceImpl): UserRemoteDataSource

    @Binds
    abstract fun bindUserRepository(userRepository: UserRepositoryImpl): UserRepository
    //endregion

    @Binds
    abstract fun bindImageFramework(imageFramework: GlideImpl): ImageFramework
}

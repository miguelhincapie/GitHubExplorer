package com.mac.githubexplorer.domain.di

import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase
import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCaseImpl
import com.mac.githubexplorer.domain.usecases.GetUserUseCase
import com.mac.githubexplorer.domain.usecases.GetUserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModuleBinds {

    @Binds
    @ViewModelScoped
    abstract fun bindGetRemoteStarredReposUseCase(
        getRemoteStarredReposUseCase: GetRemoteStarredReposUseCaseImpl
    ): GetRemoteStarredReposUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetUserUseCase(
        getUserUseCase: GetUserUseCaseImpl
    ): GetUserUseCase
}
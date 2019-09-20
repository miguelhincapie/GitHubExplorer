package com.mac.githubexplorer.presentation.di

import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase
import com.mac.githubexplorer.presentation.viewmodels.ReposViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule/*(private val app: Application)*/ {

//    @Provides
//    fun provideReposViewModelFactory(getRemoteStarredReposUseCase: GetRemoteStarredReposUseCase) =
//        ReposViewModelFactory(getRemoteStarredReposUseCase)
}
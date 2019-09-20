package com.mac.githubexplorer.presentation.views.di

import android.util.Log
import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase
import com.mac.githubexplorer.presentation.viewmodels.ReposViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    private val TAG = "dagger-MainActivityM"

    @MainActivityScope
    @Provides
    fun provideViewModelFactory(githubReposUseCase: GetRemoteStarredReposUseCase): ReposViewModelFactory {
        Log.d(TAG, "creando ReposViewModelFactory")
        return ReposViewModelFactory(githubReposUseCase)
    }
}

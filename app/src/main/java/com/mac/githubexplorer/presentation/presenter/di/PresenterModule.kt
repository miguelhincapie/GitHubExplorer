package com.mac.githubexplorer.presentation.presenter.di

import android.util.Log
import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase
import com.mac.githubexplorer.presentation.presenter.viewmodel.ReposViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun provideViewModelFactory(githubReposUseCase: GetRemoteStarredReposUseCase): ReposViewModelFactory {
        Log.d(TAG, "creating an instance of ReposViewModelFactory")
        return ReposViewModelFactory(githubReposUseCase)
    }

    companion object {
        private const val TAG = "dagger-Presentation"
    }
}

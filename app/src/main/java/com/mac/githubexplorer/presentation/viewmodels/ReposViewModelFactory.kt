package com.mac.githubexplorer.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase

class ReposViewModelFactory(private val getRemoteStarredReposUseCase: GetRemoteStarredReposUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ReposViewModel(getRemoteStarredReposUseCase) as T
    }
}
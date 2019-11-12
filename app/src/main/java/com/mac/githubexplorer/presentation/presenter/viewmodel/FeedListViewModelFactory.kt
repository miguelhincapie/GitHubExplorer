package com.mac.githubexplorer.presentation.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mac.githubexplorer.domain.usecases.GetFeedListUseCase

class FeedListViewModelFactory(
    private val getFeedListUseCase: GetFeedListUseCase
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FeedListViewModel(getFeedListUseCase) as T
    }
}
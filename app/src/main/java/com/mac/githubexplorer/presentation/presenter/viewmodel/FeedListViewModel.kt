package com.mac.githubexplorer.presentation.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mac.githubexplorer.domain.usecases.GetFeedListUseCase
import com.mac.githubexplorer.presentation.model.*
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable


class FeedListViewModel(private val getFeedListUseCase: GetFeedListUseCase) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var feedElements = MutableLiveData<Data<List<RecyclerViewType>>>()

    fun getFeedList() {
        val disposable = getFeedListUseCase().flatMap {
            Observable.fromIterable(it).map { feed -> feed.toFeedItemViewType() }.toList()
                .toObservable()
        }.subscribe(
            { response ->
                feedElements.value = Data(
                    responseType = Status.SUCCESSFUL,
                    data = response
                )
            },
            { error ->
                feedElements.value = Data(
                    responseType = Status.ERROR,
                    error = error.message
                )
            },
            {
                Log.d(FeedListViewModel::class.java.simpleName, "On Complete Called")
            }
        )
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }

    fun getFeedElementsLiveData(): LiveData<Data<List<RecyclerViewType>>> = feedElements
}
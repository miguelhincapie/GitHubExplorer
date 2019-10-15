package com.mac.githubexplorer.presentation.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mac.githubexplorer.domain.entities.Repo
import com.mac.githubexplorer.domain.entities.RepoDetail
import com.mac.githubexplorer.domain.usecases.GetGitHubRepositoryDetailUseCase
import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase
import com.mac.githubexplorer.presentation.model.Data
import com.mac.githubexplorer.presentation.model.Status
import io.reactivex.disposables.CompositeDisposable

class ReposViewModel(
    private val getRemoteStarredReposUseCase: GetRemoteStarredReposUseCase,
    private val getGitHubRepositoryDetailUseCase: GetGitHubRepositoryDetailUseCase
) :
    ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var starredRepositories = MutableLiveData<Data<List<Repo>>>()
    private var repoDetails = MutableLiveData<Data<RepoDetail>>()

    fun fetchStarredRepositories(userName: String) {
        val disposable = getRemoteStarredReposUseCase(userName).subscribe(
            { response ->
                Log.d(TAG, "On Next Called")
                starredRepositories.value = Data(
                    responseType = Status.SUCCESSFUL,
                    data = response
                )
            },
            { error ->
                Log.d(TAG, "On Error Called")
                starredRepositories.value = Data(
                    responseType = Status.ERROR,
                    error = error.message
                )
            },
            {
                Log.d(TAG, "On Complete Called")
            }
        )
        compositeDisposable.add(disposable)
    }

    fun fetchRepositoryDetail(userName: String, repoName: String) {
        val disposable = getGitHubRepositoryDetailUseCase(userName, repoName).subscribe(
            {
                Log.d(TAG, "OnSuccess")
                repoDetails.value = Data(
                    responseType = Status.SUCCESSFUL,
                    data = it
                )
            },
            {
                Log.d(TAG, "OnError")
                repoDetails.value = Data(
                    responseType = Status.ERROR,
                    error = it.message
                )
            }
        )
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        Log.d(TAG, "dagger-About to call compositeDisposable.clear()")
        compositeDisposable.clear()
    }

    fun getStarredRepositoriesLiveData(): LiveData<Data<List<Repo>>> = starredRepositories
    fun getRepoDetailsLiveData(): LiveData<Data<RepoDetail>> = repoDetails

    companion object {
        private val TAG = ReposViewModel::class.java.simpleName
    }
}
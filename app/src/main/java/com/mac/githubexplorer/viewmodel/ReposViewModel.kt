package com.mac.githubexplorer.viewmodel

import androidx.lifecycle.ViewModel
import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase
import com.mac.githubexplorer.exception.UIExceptionHandler
import com.mac.githubexplorer.exception.UIExceptionHandlerImpl
import com.mac.githubexplorer.exception.launchWithExceptionHandler
import com.mac.githubexplorer.mapper.ReposUIMapper
import com.mac.githubexplorer.model.RepoListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class ReposViewModel
@Inject constructor(
    private val getRemoteStarredReposUseCase: GetRemoteStarredReposUseCase,
    private val reposUIMapper: ReposUIMapper
) : ViewModel(), UIExceptionHandler by UIExceptionHandlerImpl() {

    private val _state: MutableStateFlow<RepoListState> = MutableStateFlow(RepoListState.Empty)
    val state = _state.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    fun fetchStarredRepositories(userName: String) {
        if (userName.isEmpty()) {
            return
        }
        launchWithExceptionHandler {
            getRemoteStarredReposUseCase.invoke(userName)
                .onStart { _state.value = RepoListState.Loading }
                .mapLatest {
                    reposUIMapper.mapToUI(it)
                }
                .collect {
                    _state.value = it
                }
        }
    }
}
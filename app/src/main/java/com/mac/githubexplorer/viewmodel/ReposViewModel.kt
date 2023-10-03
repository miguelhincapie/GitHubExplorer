package com.mac.githubexplorer.viewmodel

import androidx.lifecycle.ViewModel
import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase
import com.mac.githubexplorer.exception.UIExceptionHandler
import com.mac.githubexplorer.exception.UIExceptionHandlerImpl
import com.mac.githubexplorer.exception.launchWithExceptionHandler
import com.mac.githubexplorer.mapper.ReposUIMapper
import com.mac.githubexplorer.model.RepoListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class ReposViewModel
@Inject constructor(
    private val getRemoteStarredReposUseCase: GetRemoteStarredReposUseCase,
    private val reposUIMapper: ReposUIMapper
) : ViewModel(), UIExceptionHandler by UIExceptionHandlerImpl() {

    private val _state: MutableStateFlow<RepoListState> = MutableStateFlow(RepoListState.Loading)
    val state = _state.asStateFlow()

    fun fetchStarredRepositories(userName: String) {
        if (userName.isEmpty()) {
            return
        }
        launchWithExceptionHandler {
            getRemoteStarredReposUseCase.invoke(userName)
                .onStart { _state.value = RepoListState.Loading }
                .map {
                    reposUIMapper.mapToUI(it)
                }
                .collect {
                    _state.value = it
                }
        }
    }
}
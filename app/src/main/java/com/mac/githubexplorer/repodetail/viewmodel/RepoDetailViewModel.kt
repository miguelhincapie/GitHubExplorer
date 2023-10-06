package com.mac.githubexplorer.repodetail.viewmodel

import androidx.lifecycle.ViewModel
import com.mac.githubexplorer.commons.exception.UIExceptionHandler
import com.mac.githubexplorer.commons.exception.UIExceptionHandlerImpl
import com.mac.githubexplorer.commons.exception.launchWithExceptionHandler
import com.mac.githubexplorer.domain.usecases.GetRepoDetailUseCase
import com.mac.githubexplorer.repodetail.mapper.RepoDetailUIMapper
import com.mac.githubexplorer.repodetail.model.RepoDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class RepoDetailViewModel
@Inject constructor(
    private val getRepoDetailUseCase: GetRepoDetailUseCase,
    private val uiMapper: RepoDetailUIMapper
) : ViewModel(), UIExceptionHandler by UIExceptionHandlerImpl() {

    private val _state: MutableStateFlow<RepoDetailState> =
        MutableStateFlow(RepoDetailState.Loading)
    val state = _state.asStateFlow()

    fun fetchRepoDetail(
        userId: String,
        repoId: String
    ) = launchWithExceptionHandler {
        getRepoDetailUseCase.invoke(userId, repoId)
            .onStart { _state.value = RepoDetailState.Loading }
            .map {
                uiMapper.mapToUI(it)
            }
            .collect {
                _state.value = it
            }
    }
}
package com.mac.githubexplorer.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase
import com.mac.githubexplorer.mapper.ReposUIMapper
import com.mac.githubexplorer.model.RepoListState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReposViewModel
@Inject constructor(
    private val getRemoteStarredReposUseCase: GetRemoteStarredReposUseCase,
    private val reposUIMapper: ReposUIMapper,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _state: MutableStateFlow<RepoListState> = MutableStateFlow(RepoListState.Empty)
    val state = _state.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    fun fetchStarredRepositories(userName: String) {
        if (userName.isEmpty()) {
            return
        }
        viewModelScope.launch(context = Dispatchers.IO) {
            getRemoteStarredReposUseCase(userName)
                .onStart { _state.value = RepoListState.Loading }
                .mapLatest {
                    reposUIMapper.mapToUI(it, context)
                }
                .collect {
                    _state.value = it
                }
//            { error ->
//                Log.d(TAG, "On Error Called")
//                starredRepositories.value = Data(
//                    responseType = Status.ERROR,
//                    error = error.message
//                )
//            }
        }
    }
}
package com.mac.githubexplorer.home.viewmodel

import androidx.lifecycle.ViewModel
import com.mac.githubexplorer.domain.usecases.GetUserUseCase
import com.mac.githubexplorer.exception.UIExceptionHandler
import com.mac.githubexplorer.exception.UIExceptionHandlerImpl
import com.mac.githubexplorer.exception.launchWithExceptionHandler
import com.mac.githubexplorer.home.mapper.UserUIMapper
import com.mac.githubexplorer.home.model.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val userUIMapper: UserUIMapper
) : ViewModel(), UIExceptionHandler by UIExceptionHandlerImpl() {

    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState.NoUserSelected)
    val state = _state.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getUser(userName: String) {
        if (userName.isEmpty()) {
            _state.value = HomeState.NoUserSelected
            return
        }
        launchWithExceptionHandler {
            getUserUseCase.invoke(userName)
                .onStart { _state.value = HomeState.Loading }
                .mapLatest {
                    userUIMapper.mapToUI(it)
                }
                .collect {
                    _state.value = it
                }
        }
    }
}
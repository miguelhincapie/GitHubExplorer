package com.mac.githubexplorer.home.model

sealed class HomeState {
    data object NoUserSelected : HomeState()
    data object Loading : HomeState()
    data object NoUserFound : HomeState()
    data class ShowUserInfo(val userUI: UserUI) : HomeState()
}

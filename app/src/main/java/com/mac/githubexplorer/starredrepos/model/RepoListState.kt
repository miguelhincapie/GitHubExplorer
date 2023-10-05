package com.mac.githubexplorer.starredrepos.model

sealed class RepoListState {
    data object Loading : RepoListState()
    data object Empty : RepoListState()
    data class ShowingList(val list: List<RepoRowUI>) : RepoListState()
}

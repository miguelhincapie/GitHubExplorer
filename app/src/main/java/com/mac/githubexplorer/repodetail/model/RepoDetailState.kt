package com.mac.githubexplorer.repodetail.model

sealed class RepoDetailState {
    data object Loading : RepoDetailState()
    data object Error : RepoDetailState()
    data class ShowingRepoDetail(val model: RepoDetailUI) : RepoDetailState()
}

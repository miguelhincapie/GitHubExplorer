package com.mac.githubexplorer.mapper

import android.content.Context
import com.mac.githubexplorer.R
import com.mac.githubexplorer.domain.model.Repo
import com.mac.githubexplorer.model.RepoListState
import com.mac.githubexplorer.model.RepoRowUI
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ReposUIMapper @Inject constructor() {

    fun mapToUI(domainList: List<Repo>?, context: Context): RepoListState {
        return when {
            domainList.isNullOrEmpty() -> RepoListState.Empty
            else -> RepoListState.ShowingList(domainList.map { it.toUI(context) })
        }
    }

    private fun Repo.toUI(context: Context): RepoRowUI {
        return RepoRowUI(
            id = id,
            name = name,
            htmlUrl = htmlUrl,
            description = description,
            language = String.format(context.getString(R.string.language), language),
            stargazersCount = String.format(context.getString(R.string.stars), stargazersCount)
        )
    }
}
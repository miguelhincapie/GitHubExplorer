package com.mac.githubexplorer.starredrepos.mapper

import android.content.Context
import com.mac.githubexplorer.R
import com.mac.githubexplorer.domain.model.Repo
import com.mac.githubexplorer.starredrepos.model.RepoListState
import com.mac.githubexplorer.starredrepos.model.RepoRowUI
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ReposUIMapper @Inject constructor(
    @ApplicationContext private val context: Context
) {

    fun mapToUI(domainList: List<Repo>?): RepoListState {
        return when {
            domainList.isNullOrEmpty() -> RepoListState.Empty
            else -> RepoListState.ShowingList(domainList.map { it.toRepoRowUI(context) })
        }
    }

    private fun Repo.toRepoRowUI(context: Context): RepoRowUI {
        return RepoRowUI(
            name = name,
            description = description,
            language = String.format(context.getString(R.string.language), language),
            stargazersCount = String.format(context.getString(R.string.stars), stargazersCount),
            ownerLogin = ownerLogin
        )
    }
}
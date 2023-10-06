package com.mac.githubexplorer.repodetail.mapper

import android.content.Context
import com.mac.githubexplorer.R
import com.mac.githubexplorer.domain.model.Repo
import com.mac.githubexplorer.repodetail.model.RepoDetailState
import com.mac.githubexplorer.repodetail.model.RepoDetailUI
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class RepoDetailUIMapper @Inject constructor(
    @ApplicationContext private val context: Context
) {

    fun mapToUI(domainModel: Repo?): RepoDetailState {
        return when (domainModel) {
            null -> RepoDetailState.Error
            else -> RepoDetailState.ShowingRepoDetail(domainModel.toRepoDetailUI(context))
        }
    }

    private fun Repo.toRepoDetailUI(context: Context): RepoDetailUI {
        return RepoDetailUI(
            name = name,
            description = description,
            license = license?.name ?: "",
            language = String.format(context.getString(R.string.language), language),
            stargazersCount = String.format(context.getString(R.string.stars), stargazersCount),
            htmlUrl = htmlUrl,
            homepage = homepage,
            forks = forks.toString(),
            topics = topics
        )
    }
}
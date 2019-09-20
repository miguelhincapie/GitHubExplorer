package com.mac.githubexplorer.data.repositories

import com.mac.githubexplorer.domain.entities.Repo
import com.mac.githubexplorer.data.db.entities.RepoDB
import com.mac.githubexplorer.data.remote.dtos.RepoNetwork

fun RepoNetwork.toRepo() = Repo(
    id = id ?: -1,
    name = name.orEmpty(),
    htmlUrl = htmlUrl.orEmpty(),
    description = description.orEmpty(),
    language = language.orEmpty(),
    stargazersCount = stargazersCount ?: -1
)

fun RepoDB.toRepo() = Repo(
    id = id,
    name = name,
    htmlUrl = htmlUrl,
    description = description,
    language = language,
    stargazersCount = stargazersCount
)

fun Repo.toRepoDB() = RepoDB(
    id = id,
    name = name,
    htmlUrl = htmlUrl,
    description = description,
    language = language,
    stargazersCount = stargazersCount
)
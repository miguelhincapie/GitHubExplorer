package com.mac.githubexplorer.data.repositories

import com.mac.githubexplorer.data.db.entities.RepoDB
import com.mac.githubexplorer.data.remote.dtos.OwnerNetwork
import com.mac.githubexplorer.data.remote.dtos.RepoDetailNetwork
import com.mac.githubexplorer.data.remote.dtos.RepoNetwork
import com.mac.githubexplorer.domain.entities.Owner
import com.mac.githubexplorer.domain.entities.Repo
import com.mac.githubexplorer.domain.entities.RepoDetail

fun RepoNetwork.toRepo() = Repo(
    id = id ?: -1,
    name = name.orEmpty(),
    htmlUrl = htmlUrl.orEmpty(),
    description = description.orEmpty(),
    language = language.orEmpty(),
    stargazersCount = stargazersCount ?: -1,
    owner = ownerNetwork?.toOwner() ?: Owner()
)

fun OwnerNetwork.toOwner() = Owner(
    login = login.orEmpty(),
    id = id ?: -1,
    avatarUrl = avatarUrl.orEmpty(),
    gravatarId = gravatarId.orEmpty(),
    url = url.orEmpty()
)

fun RepoDB.toRepo() = Repo(
    id = id,
    name = name,
    htmlUrl = htmlUrl,
    description = description,
    language = language,
    stargazersCount = stargazersCount,
    owner = Owner()
)

fun Repo.toRepoDB() = RepoDB(
    id = id,
    name = name,
    htmlUrl = htmlUrl,
    description = description,
    language = language,
    stargazersCount = stargazersCount
)

fun RepoDetailNetwork.toRepoDetail() = RepoDetail(
    id = id ?: -1,
    name = name.orEmpty(),
    htmlUrl = htmlUrl.orEmpty(),
    description = description.orEmpty(),
    language = language.orEmpty(),
    stargazersCount = stargazersCount ?: -1,
    fullName = fullName.orEmpty(),
    private = private ?: false,
    createdAt = createdAt.orEmpty(),
    watchersCount = watchersCount ?: -1,
    forks = forks ?: -1,
    openIssues = openIssues ?: -1,
    defaultBranch = defaultBranch.orEmpty()
)
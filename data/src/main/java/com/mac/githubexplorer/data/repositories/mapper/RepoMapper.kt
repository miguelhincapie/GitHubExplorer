package com.mac.githubexplorer.data.repositories.mapper

import com.mac.githubexplorer.data.repositories.local.db.entities.RepoDB
import com.mac.githubexplorer.data.repositories.remote.dto.RepoDTO
import com.mac.githubexplorer.domain.model.Repo

fun RepoDTO.toDomain() = Repo(
    id = id ?: -1,
    name = name.orEmpty(),
    htmlUrl = htmlUrl.orEmpty(),
    description = description.orEmpty(),
    language = language.orEmpty(),
    stargazersCount = stargazersCount ?: -1
)

fun RepoDB.toDomain() = Repo(
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
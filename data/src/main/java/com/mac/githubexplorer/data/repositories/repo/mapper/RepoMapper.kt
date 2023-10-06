package com.mac.githubexplorer.data.repositories.repo.mapper

import com.mac.githubexplorer.data.repositories.repo.local.entities.RepoDB
import com.mac.githubexplorer.data.repositories.repo.remote.dto.RepoDTO
import com.mac.githubexplorer.domain.model.Repo

fun RepoDTO.toDomain() = Repo(
    id = id ?: -1,
    name = name.orEmpty(),
    fullName = fullName.orEmpty(),
    private = private ?: false,
    htmlUrl = htmlUrl.orEmpty(),
    description = description.orEmpty(),
    url = url.orEmpty(),
    language = language.orEmpty(),
    stargazersCount = stargazersCount ?: -1,
    homepage = homepage.orEmpty(),
    license = license?.toDomain(),
    topics = topics.orEmpty(),
    forks = forks ?: 0,
    ownerLogin = owner?.login ?: ""
)

fun RepoDB.toDomain() = Repo(
    id = id,
    name = name,
    fullName = fullName,
    private = private ?: false,
    htmlUrl = htmlUrl,
    description = description,
    url = url.orEmpty(),
    language = language,
    stargazersCount = stargazersCount,
    homepage = homepage.orEmpty(),
    license = license?.toDomain(),
    topics = topics.orEmpty(),
    forks = forks ?: 0,
    ownerLogin = ownerLogin.orEmpty()
)
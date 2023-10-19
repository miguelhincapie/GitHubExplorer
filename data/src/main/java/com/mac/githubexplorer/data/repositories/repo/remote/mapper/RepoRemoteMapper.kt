package com.mac.githubexplorer.data.repositories.repo.remote.mapper

import com.mac.githubexplorer.data.repositories.repo.remote.dto.LicenseDTO
import com.mac.githubexplorer.data.repositories.repo.remote.dto.RepoDTO
import com.mac.githubexplorer.domain.model.License
import com.mac.githubexplorer.domain.model.Repo
import javax.inject.Inject

class RepoRemoteMapper @Inject constructor() {

    fun repoToDomain(repoDTO: RepoDTO): Repo = with(repoDTO) {
        return Repo(
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
            license = license?.let { licenseToDomain(it) },
            topics = topics.orEmpty(),
            forks = forks ?: 0,
            ownerLogin = owner?.login ?: ""
        )
    }

    private fun licenseToDomain(licenseDTO: LicenseDTO): License = with(licenseDTO) {
        return License(
            key = key.orEmpty(),
            name = name.orEmpty(),
            spdxId = spdxId.orEmpty(),
            url = url.orEmpty()
        )
    }
}
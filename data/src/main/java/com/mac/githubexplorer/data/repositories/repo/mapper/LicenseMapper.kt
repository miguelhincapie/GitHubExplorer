package com.mac.githubexplorer.data.repositories.repo.mapper

import com.mac.githubexplorer.data.repositories.repo.remote.dto.LicenseDTO
import com.mac.githubexplorer.domain.model.License

fun LicenseDTO.toDomain() = License(
    key = key.orEmpty(),
    name = name.orEmpty(),
    spdxId = spdxId.orEmpty(),
    url = url.orEmpty()
)
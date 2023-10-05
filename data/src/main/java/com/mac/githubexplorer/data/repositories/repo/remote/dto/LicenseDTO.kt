package com.mac.githubexplorer.data.repositories.repo.remote.dto

import com.google.gson.annotations.SerializedName

data class LicenseDTO(
    @SerializedName("key")
    val key: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("spdx_id")
    val spdxId: String?,
    @SerializedName("url")
    val url: String?
)
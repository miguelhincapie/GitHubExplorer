package com.mac.githubexplorer.data.remote.dtos

import com.google.gson.annotations.SerializedName

/**
 * Network DTO.
 * Only a few fields are being held from github's response.
 */
data class RepoNetwork(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("htmlUrl")
    val htmlUrl: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("stargazers_count")
    val stargazersCount: Int?
)
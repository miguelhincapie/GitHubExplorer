package com.mac.githubexplorer.data.repositories.remote.dto

import com.google.gson.annotations.SerializedName

// Network DTO
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
    @SerializedName("stargazersCount")
    val stargazersCount: Int?
)
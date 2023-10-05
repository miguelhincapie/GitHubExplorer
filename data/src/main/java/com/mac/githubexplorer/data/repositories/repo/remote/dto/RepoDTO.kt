package com.mac.githubexplorer.data.repositories.repo.remote.dto

import com.google.gson.annotations.SerializedName

// Network DTO
data class RepoDTO(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("full_name")
    val fullName: String?,
    @SerializedName("private")
    val private: Boolean?,
    @SerializedName("htmlUrl")
    val htmlUrl: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("stargazers_count")
    val stargazersCount: Int?,
    @SerializedName("homepage")
    val homepage: String?,
    @SerializedName("license")
    val license: LicenseDTO?,
    @SerializedName("topics")
    val topics: List<String>?,
    @SerializedName("forks")
    val forks: Int?
)
package com.mac.githubexplorer.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class RepoDetailNetwork(
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
    val stargazersCount: Int?,
    @SerializedName("full_name")
    val fullName: String?,
    @SerializedName("private")
    val private: Boolean?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("watchers_count")
    val watchersCount: Int?,
    @SerializedName("folks")
    val forks: Int?,
    @SerializedName("open_issues")
    val openIssues: Int?,
    @SerializedName("default_branch")
    val defaultBranch: String?
)
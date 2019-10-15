package com.mac.githubexplorer.domain.entities

data class RepoDetail(
    val id: Int = 0,
    val name: String = "",
    val htmlUrl: String = "",
    val description: String = "",
    val language: String = "",
    val stargazersCount: Int = 0,
    val fullName: String = "",
    val private: Boolean = false,
    val createdAt: String = "",
    val watchersCount: Int = 0,
    val forks: Int = 0,
    val openIssues: Int = 0,
    val defaultBranch: String = ""
)
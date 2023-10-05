package com.mac.githubexplorer.domain.model

data class Repo(
    val id: Int,
    val name: String,
    val fullName: String,
    val private: Boolean,
    val htmlUrl: String,
    val description: String,
    val url: String,
    val language: String,
    val stargazersCount: Int,
    val homepage: String,
    val license: License?,
    val topics: List<String>,
    val forks: Int
)
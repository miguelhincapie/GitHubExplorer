package com.mac.githubexplorer.repodetail.model

data class RepoDetailUI(
    val name: String,
    val description: String,
    val license: String,
    val language: String,
    val stargazersCount: String,
    val htmlUrl: String,
    val homepage: String,
    val forks: String,
    val topics: List<String>
)

package com.mac.githubexplorer.starredrepos.model

data class RepoRowUI(
    val id: Int = 0,
    val name: String = "",
    val htmlUrl: String = "",
    val description: String = "",
    val language: String = "",
    val stargazersCount: String = ""
)

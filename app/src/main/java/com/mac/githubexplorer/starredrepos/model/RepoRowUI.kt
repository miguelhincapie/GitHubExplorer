package com.mac.githubexplorer.starredrepos.model

data class RepoRowUI(
    val name: String,
    val description: String,
    val language: String,
    val stargazersCount: String,
    val ownerLogin: String
)

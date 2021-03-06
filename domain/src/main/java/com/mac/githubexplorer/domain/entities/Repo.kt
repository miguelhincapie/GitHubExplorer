package com.mac.githubexplorer.domain.entities

data class Repo(val id: Int = 0,
                val name: String = "",
                val htmlUrl: String = "",
                val description: String = "",
                val language: String = "",
                val stargazersCount: Int = 0)
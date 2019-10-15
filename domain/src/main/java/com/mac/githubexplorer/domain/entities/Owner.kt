package com.mac.githubexplorer.domain.entities

data class Owner(
    val login: String = "",
    val id: Int = -1,
    val avatarUrl: String = "",
    val gravatarId: String = "",
    val url: String = ""
)
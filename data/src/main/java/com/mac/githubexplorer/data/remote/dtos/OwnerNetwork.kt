package com.mac.githubexplorer.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class OwnerNetwork(
    @SerializedName("login")
    val login: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    @SerializedName("gravatar_id")
    val gravatarId: String?,
    @SerializedName("url")
    val url: String?
)
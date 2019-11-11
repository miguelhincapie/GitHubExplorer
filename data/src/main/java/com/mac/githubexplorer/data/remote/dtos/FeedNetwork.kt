package com.mac.githubexplorer.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class FeedNetwork(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("first_name")
    val first_name: String?,
    @SerializedName("last_name")
    val last_name: String?,
    @SerializedName("post_body")
    val post_body: String?,
    @SerializedName("unix_timestamp")
    val unix_timestamp: String?,
    @SerializedName("image")
    val image: String?
)
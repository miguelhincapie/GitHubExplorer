package com.mac.githubexplorer.domain.entities

data class Feed(
    val id: Int,
    val first_name: String,
    val last_name: String,
    val post_body: String,
    val unix_timestamp: String,
    val image: String
)
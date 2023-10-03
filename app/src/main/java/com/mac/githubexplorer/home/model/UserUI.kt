package com.mac.githubexplorer.home.model

import android.graphics.drawable.Drawable

data class UserUI(
    val avatar: Drawable,
    val visualName: String,
    val accountName: String,
    val description: String,
    val followers: String,
    val following: String
)
package com.mac.githubexplorer.domain.image

import android.graphics.drawable.Drawable

interface ImageFramework {
    suspend fun loadImage(url: String): Drawable?
}
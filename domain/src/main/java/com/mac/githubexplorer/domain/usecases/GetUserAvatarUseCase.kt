package com.mac.githubexplorer.domain.usecases

import android.graphics.drawable.Drawable

interface GetUserAvatarUseCase {
    suspend operator fun invoke(avatarUrl: String?): Drawable?
}
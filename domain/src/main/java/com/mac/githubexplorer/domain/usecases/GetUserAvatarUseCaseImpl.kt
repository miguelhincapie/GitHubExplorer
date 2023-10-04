package com.mac.githubexplorer.domain.usecases

import android.graphics.drawable.Drawable
import com.mac.githubexplorer.domain.image.ImageFramework
import javax.inject.Inject

class GetUserAvatarUseCaseImpl @Inject constructor(
    private val imageFramework: ImageFramework
) : GetUserAvatarUseCase {
    override suspend operator fun invoke(
        avatarUrl: String?
    ): Drawable? {
        return avatarUrl?.let { imageFramework.loadImage(it) }
    }
}
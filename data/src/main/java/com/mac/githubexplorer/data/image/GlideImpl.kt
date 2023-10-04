package com.mac.githubexplorer.data.image

import android.content.Context
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.mac.githubexplorer.domain.image.ImageFramework
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class GlideImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ImageFramework {
    override suspend fun loadImage(
        url: String
    ): Drawable? {
        val futureTarget = Glide.with(context)
            .asDrawable()
            .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
            .load(url)
            .submit(SIZE_ORIGINAL, SIZE_ORIGINAL)

        return try {
            val image = futureTarget.get()
            Glide.with(context).clear(futureTarget)
            image
        } catch (e: Throwable) {
            null
        }
    }
}
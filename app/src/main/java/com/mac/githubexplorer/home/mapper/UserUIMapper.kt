package com.mac.githubexplorer.home.mapper

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import com.mac.githubexplorer.R
import com.mac.githubexplorer.domain.model.User
import com.mac.githubexplorer.home.model.HomeState
import com.mac.githubexplorer.home.model.UserUI
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class UserUIMapper @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun mapToUI(domainModel: User?, avatar: Drawable?): HomeState {
        return when (domainModel) {
            null -> HomeState.NoUserFound
            else -> HomeState.ShowUserInfo(domainToUI(domainModel, avatar))
        }
    }

    private fun domainToUI(user: User, avatar: Drawable?): UserUI {
        return UserUI(
            avatar = avatar ?: AppCompatResources.getDrawable(context, R.drawable.ic_empty)!!,
            visualName = user.name,
            accountName = user.login,
            description = user.bio,
            followers = String.format(context.getString(R.string.followers), user.followers),
            following = String.format(context.getString(R.string.following), user.following)
        )
    }
}
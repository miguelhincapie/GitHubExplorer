package com.mac.githubexplorer.data.repositories.user.local.mapper

import com.mac.githubexplorer.data.repositories.user.local.entity.UserEntity
import com.mac.githubexplorer.domain.model.User
import javax.inject.Inject

class UserLocalMapper @Inject constructor() {

    fun userToDomain(userEntity: UserEntity): User = with(userEntity) {
        return User(
            login = login ?: "",
            id = id,
            nodeId = nodeId ?: "",
            avatarUrl = avatarUrl ?: "",
            gravatarId = gravatarId ?: "",
            url = url ?: "",
            htmlUrl = htmlUrl ?: "",
            followersUrl = followersUrl ?: "",
            followingUrl = followingUrl ?: "",
            gistsUrl = gistsUrl ?: "",
            starredUrl = starredUrl ?: "",
            subscriptionsUrl = subscriptionsUrl ?: "",
            organizationsUrl = organizationsUrl ?: "",
            reposUrl = reposUrl ?: "",
            eventsUrl = eventsUrl ?: "",
            receivedEventsUrl = receivedEventsUrl ?: "",
            type = type ?: "",
            siteAdmin = siteAdmin ?: false,
            name = name ?: "",
            company = company ?: "",
            blog = blog ?: "",
            location = location ?: "",
            email = email ?: "",
            hireable = hireable ?: false,
            bio = bio ?: "",
            twitterUsername = twitterUsername ?: "",
            publicRepos = publicRepos ?: -1,
            publicGists = publicGists ?: -1,
            followers = followers ?: 0,
            following = following ?: 0,
            createdAt = createdAt ?: "",
            updatedAt = updatedAt ?: ""
        )
    }

    fun userToLocal(user: User): UserEntity = with(user) {
        return UserEntity(
            login = login,
            id = id,
            nodeId = nodeId,
            avatarUrl = avatarUrl,
            gravatarId = gravatarId,
            url = url,
            htmlUrl = htmlUrl,
            followersUrl = followersUrl,
            followingUrl = followingUrl,
            gistsUrl = gistsUrl,
            starredUrl = starredUrl,
            subscriptionsUrl = subscriptionsUrl,
            organizationsUrl = organizationsUrl,
            reposUrl = reposUrl,
            eventsUrl = eventsUrl,
            receivedEventsUrl = receivedEventsUrl,
            type = type,
            siteAdmin = siteAdmin,
            name = name,
            company = company,
            blog = blog,
            location = location,
            email = email,
            hireable = hireable,
            bio = bio,
            twitterUsername = twitterUsername,
            publicRepos = publicRepos,
            publicGists = publicGists,
            followers = followers,
            following = following,
            createdAt = createdAt,
            updatedAt = updatedAt
        )
    }
}
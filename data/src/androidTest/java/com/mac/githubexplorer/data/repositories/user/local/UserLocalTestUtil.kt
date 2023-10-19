package com.mac.githubexplorer.data.repositories.user.local

import com.mac.githubexplorer.data.repositories.user.local.entity.UserEntity
import kotlin.random.Random

class UserLocalTestUtil {

    fun createDbUser(id: Int, login: String): UserEntity {
        return UserEntity(
            login = login,
            id = id,
            nodeId = null,
            avatarUrl = null,
            gravatarId = null,
            url = null,
            htmlUrl = null,
            followersUrl = null,
            followingUrl = null,
            gistsUrl = null,
            starredUrl = null,
            subscriptionsUrl = null,
            organizationsUrl = null,
            reposUrl = null,
            eventsUrl = null,
            receivedEventsUrl = null,
            type = null,
            siteAdmin = null,
            name = null,
            company = null,
            blog = null,
            location = null,
            email = null,
            hireable = null,
            bio = null,
            twitterUsername = null,
            publicRepos = null,
            publicGists = null,
            followers = null,
            following = null,
            createdAt = null,
            updatedAt = null
        )
    }
}
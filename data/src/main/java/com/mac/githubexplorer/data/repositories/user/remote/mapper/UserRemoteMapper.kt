package com.mac.githubexplorer.data.repositories.user.remote.mapper

import com.mac.githubexplorer.data.repositories.user.remote.dto.UserDTO
import com.mac.githubexplorer.domain.model.User
import javax.inject.Inject

class UserRemoteMapper @Inject constructor() {

    fun userToDomain(userDTO: UserDTO): User = with(userDTO) {
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
}
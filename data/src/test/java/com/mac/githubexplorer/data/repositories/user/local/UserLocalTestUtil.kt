package com.mac.githubexplorer.data.repositories.user.local

import com.mac.githubexplorer.data.repositories.user.local.entity.UserEntity
import com.mac.githubexplorer.domain.model.User

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

    fun createDomainModel(userEntity: UserEntity): User {
        return User(
            login = userEntity.login!!,
            id = userEntity.id,
            nodeId = "lorem",
            avatarUrl = "https://www.google.com/#q=oporteat",
            gravatarId = "quod",
            url = "http://www.bing.com/search?q=principes",
            htmlUrl = "https://duckduckgo.com/?q=vulputate",
            followersUrl = "https://www.google.com/#q=eripuit",
            followingUrl = "https://search.yahoo.com/search?p=mediocritatem",
            gistsUrl = "http://www.bing.com/search?q=dico",
            starredUrl = "http://www.bing.com/search?q=consetetur",
            subscriptionsUrl = "https://duckduckgo.com/?q=inceptos",
            organizationsUrl = "http://www.bing.com/search?q=veniam",
            reposUrl = "https://www.google.com/#q=propriae",
            eventsUrl = "https://www.google.com/#q=dissentiunt",
            receivedEventsUrl = "https://duckduckgo.com/?q=regione",
            type = "volutpat",
            siteAdmin = false,
            name = "Jerry Todd",
            company = "eget",
            blog = "ignota",
            location = "electram",
            email = "leticia.fox@example.com",
            hireable = false,
            bio = "natoque",
            twitterUsername = "Maricela Park",
            publicRepos = 8313,
            publicGists = 2125,
            followers = 7481,
            following = 3752,
            createdAt = "risus",
            updatedAt = "proin"
        )
    }
}
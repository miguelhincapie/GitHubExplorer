package com.mac.githubexplorer.data.repositories.user.remote

import com.mac.githubexplorer.data.repositories.user.remote.dto.UserDTO
import com.mac.githubexplorer.domain.model.User

class UserRemoteTestUtil {

    fun createDTOUser(login: String, id: Int): UserDTO {
        return UserDTO(
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

    fun createDomainUser(userDTO: UserDTO): User {
        return User(
            login = userDTO.login!!,
            id = userDTO.id,
            nodeId = "ac",
            avatarUrl = "https://search.yahoo.com/search?p=erat",
            gravatarId = "dolorum",
            url = "https://search.yahoo.com/search?p=volumus",
            htmlUrl = "https://duckduckgo.com/?q=novum",
            followersUrl = "http://www.bing.com/search?q=habitasse",
            followingUrl = "https://search.yahoo.com/search?p=ridens",
            gistsUrl = "http://www.bing.com/search?q=ullamcorper",
            starredUrl = "http://www.bing.com/search?q=contentiones",
            subscriptionsUrl = "https://www.google.com/#q=debet",
            organizationsUrl = "https://duckduckgo.com/?q=dolores",
            reposUrl = "https://www.google.com/#q=mnesarchum",
            eventsUrl = "https://duckduckgo.com/?q=assueverit",
            receivedEventsUrl = "https://search.yahoo.com/search?p=augue",
            type = "eget",
            siteAdmin = false,
            name = "Shelly Ayers",
            company = "honestatis",
            blog = "cubilia",
            location = "lacus",
            email = "louie.henderson@example.com",
            hireable = false,
            bio = "tale",
            twitterUsername = "Rex Flores",
            publicRepos = 3119,
            publicGists = 8392,
            followers = 3644,
            following = 6695,
            createdAt = "habemus",
            updatedAt = "labores"
        )
    }
}
package com.mac.githubexplorer.data.repositories

import com.mac.githubexplorer.data.remote.dtos.FeedNetwork
import com.mac.githubexplorer.domain.entities.Feed

fun FeedNetwork.toFeed() = Feed(
    id = id ?: -1,
    first_name = first_name.orEmpty(),
    last_name = last_name.orEmpty(),
    post_body = post_body.orEmpty(),
    unix_timestamp = unix_timestamp.orEmpty(),
    image = image.orEmpty()
)
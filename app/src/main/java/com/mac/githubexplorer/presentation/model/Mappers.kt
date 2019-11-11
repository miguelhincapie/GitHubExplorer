package com.mac.githubexplorer.presentation.model

import com.mac.githubexplorer.domain.entities.Feed

fun Feed.toFeedItemViewType() = FeedItemViewType(this)
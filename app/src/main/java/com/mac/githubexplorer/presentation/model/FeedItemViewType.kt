package com.mac.githubexplorer.presentation.model

import com.mac.githubexplorer.domain.entities.Feed

class FeedItemViewType(val feed: Feed) : RecyclerViewType {

    override fun getViewTypeId() = feed.id

    override fun getViewType() = FEED_ITEM.hashCode()

    companion object {
        const val FEED_ITEM = "Feed_delegate_item"
    }
}
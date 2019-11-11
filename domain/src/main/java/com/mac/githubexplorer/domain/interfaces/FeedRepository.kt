package com.mac.githubexplorer.domain.interfaces

import com.mac.githubexplorer.domain.entities.Feed
import io.reactivex.Observable

interface FeedRepository {
    fun getFeedList(): Observable<List<Feed>>
}
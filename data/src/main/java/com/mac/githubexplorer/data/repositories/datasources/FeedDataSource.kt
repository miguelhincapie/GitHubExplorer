package com.mac.githubexplorer.data.repositories.datasources

import com.mac.githubexplorer.domain.entities.Feed
import io.reactivex.Observable

interface FeedDataSource {
    fun getFeedList(): Observable<List<Feed>>
}
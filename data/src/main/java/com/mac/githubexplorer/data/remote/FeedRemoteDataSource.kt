package com.mac.githubexplorer.data.remote

import com.mac.githubexplorer.data.remote.api.FeedService
import com.mac.githubexplorer.data.repositories.datasources.FeedDataSource
import com.mac.githubexplorer.data.repositories.toFeed
import com.mac.githubexplorer.domain.entities.Feed
import io.reactivex.Observable

class FeedRemoteDataSource(private val feedService: FeedService) : FeedDataSource {
    override fun getFeedList(): Observable<List<Feed>> {
        return feedService.getFeedList().flatMap {
            Observable.fromIterable(it)
                .map { feedNetwork -> feedNetwork.toFeed() }
                .toList()
                .toObservable()
        }
    }
}
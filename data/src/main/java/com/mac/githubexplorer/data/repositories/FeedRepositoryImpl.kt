package com.mac.githubexplorer.data.repositories

import com.mac.githubexplorer.data.remote.FeedRemoteDataSource
import com.mac.githubexplorer.domain.entities.Feed
import com.mac.githubexplorer.domain.interfaces.FeedRepository
import io.reactivex.Observable

class FeedRepositoryImpl(private val feedRemoteDataSource: FeedRemoteDataSource): FeedRepository {
    override fun getFeedList(): Observable<List<Feed>> {
        return feedRemoteDataSource.getFeedList()
    }
}
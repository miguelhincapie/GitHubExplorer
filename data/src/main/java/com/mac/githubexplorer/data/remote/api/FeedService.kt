package com.mac.githubexplorer.data.remote.api

import com.mac.githubexplorer.data.remote.dtos.FeedNetwork
import io.reactivex.Observable
import retrofit2.http.GET

interface FeedService {
    @GET("/feed")
    fun getFeedList(): Observable<List<FeedNetwork>>
}
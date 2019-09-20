package com.mac.githubexplorer.data.remote.api

import com.mac.githubexplorer.domain.entities.Repo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubReposService {

    @GET("users/{user}/starred")
    fun getStarredRepositories(@Path("user") userName: String): Observable<List<Repo>>
}
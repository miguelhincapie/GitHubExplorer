package com.mac.githubexplorer.data.remote.api

import com.mac.githubexplorer.data.remote.dtos.RepoDetailNetwork
import com.mac.githubexplorer.data.remote.dtos.RepoNetwork
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubReposService {

    @GET("users/{user}/starred")
    fun getStarredRepositories(@Path("user") userName: String): Observable<List<RepoNetwork>>

    @GET("repos/{user}/{repo_name}")
    fun getRepoDetails(
        @Path("user") userName: String,
        @Path("user") repo_name: String
    ): Single<RepoDetailNetwork>
}
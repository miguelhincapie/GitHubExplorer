package com.mac.githubexplorer.data.repositories.remote.api

import com.mac.githubexplorer.domain.model.Repo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubReposService {

    @GET("users/{user}/starred")
    suspend fun getStarredRepositories(@Path("user") userName: String): Response<List<Repo>>
}
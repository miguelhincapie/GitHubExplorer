package com.mac.githubexplorer.data.repositories.remote.api

import com.mac.githubexplorer.data.repositories.remote.dto.RepoDTO
import com.mac.githubexplorer.data.repositories.remote.dto.UserDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubReposService {

    @GET("users/{username}")
    suspend fun getUser(@Path("username") userName: String): Response<UserDTO>

    @GET("users/{user}/starred")
    suspend fun getStarredRepositories(@Path("user") userName: String): Response<List<RepoDTO>>
}
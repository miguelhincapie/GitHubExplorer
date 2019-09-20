package com.mac.githubexplorer.data.remote

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.mac.githubexplorer.data.remote.api.GitHubReposService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder(okHttpClient: OkHttpClient) {

    var retrofitInstance: Retrofit
        private set

    init {
        val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

        retrofitInstance = Retrofit.Builder()
            .baseUrl(GITHUB_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    fun getGitHubReposService(): GitHubReposService =
        retrofitInstance.create(GitHubReposService::class.java)

    companion object {
        private const val GITHUB_BASE_URL = "https://api.github.com/"
    }
}
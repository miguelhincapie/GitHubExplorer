package com.mac.githubexplorer.data.interceptor

import com.mac.githubexplorer.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class GitHubAuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest: Request = chain.request().newBuilder()
            .addHeader("Authorization", BuildConfig.GITHUB_KEY)
            .build()
        return chain.proceed(newRequest)
    }
}
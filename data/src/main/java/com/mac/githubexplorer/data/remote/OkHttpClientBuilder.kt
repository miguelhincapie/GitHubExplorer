package com.mac.githubexplorer.data.remote

import com.mac.githubexplorer.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class OkHttpClientBuilder {
    /**
     * For simplicity nothing related to cache is build/added.
     */
    fun build(): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()

        if (BuildConfig.BUILD_TYPE == "debug") {
            okHttpBuilder.addInterceptor(interceptor)
        }
        return okHttpBuilder.build()
    }

    val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }
}
package com.mac.githubexplorer.data.remote

import com.mac.githubexplorer.data.BuildConfig
import okhttp3.OkHttpClient

class OkHttpClientBuilder {
    var okHttpClientInstance: OkHttpClient
        private set

    init {
        val okHttpBuilder = OkHttpClient.Builder()

        if (BuildConfig.BUILD_TYPE != "debug") {
            okHttpBuilder.addInterceptor { chain ->
                println(chain.request())
                chain.proceed(chain.request())
            }
        }
        okHttpClientInstance = okHttpBuilder.build()
    }
}
package com.mac.githubexplorer.data.remote

import com.mac.githubexplorer.data.BuildConfig
import okhttp3.OkHttpClient

class OkHttpClientBuilder {
    /**
     * For simplicity nothing related to cache is build/added.
     */
    fun build(): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()

        if (BuildConfig.BUILD_TYPE != "debug") {
            okHttpBuilder.addInterceptor { chain ->
                println(chain.request())
                chain.proceed(chain.request())
            }
        }
        return okHttpBuilder.build()
    }
}
package com.mac.githubexplorer.data.di

import com.mac.githubexplorer.data.remote.FeedRemoteDataSource
import com.mac.githubexplorer.data.remote.OkHttpClientBuilder
import com.mac.githubexplorer.data.remote.RetrofitBuilder
import com.mac.githubexplorer.data.remote.api.FeedService
import com.mac.githubexplorer.data.repositories.FeedRepositoryImpl
import com.mac.githubexplorer.domain.interfaces.FeedRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
class DataModule {

    @DataScope
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClientBuilder().build()
    }

    @DataScope
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return RetrofitBuilder(okHttpClient).build()
    }

    @DataScope
    @Provides
    fun provideFeedService(retrofit: Retrofit): FeedService {
        return retrofit.create(FeedService::class.java)
    }

    @Provides
    fun provideFeedRemoteDataSource(feedService: FeedService): FeedRemoteDataSource {
        return FeedRemoteDataSource(feedService)
    }

    @Provides
    fun provideFeedListRepositoryImpl(feedRemoteDataSource: FeedRemoteDataSource): FeedRepository {
        return FeedRepositoryImpl(feedRemoteDataSource)
    }
}

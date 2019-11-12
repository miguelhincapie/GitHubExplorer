package com.mac.githubexplorer.data.di

import android.util.Log
import com.mac.githubexplorer.data.remote.FeedRemoteDataSource
import com.mac.githubexplorer.data.remote.OkHttpClientBuilder
import com.mac.githubexplorer.data.remote.RepoRemoteDataSource
import com.mac.githubexplorer.data.remote.RetrofitBuilder
import com.mac.githubexplorer.data.remote.api.FeedService
import com.mac.githubexplorer.data.remote.api.GitHubReposService
import com.mac.githubexplorer.data.repositories.FeedRepositoryImpl
import com.mac.githubexplorer.data.repositories.GitHubReposRepositoryImpl
import com.mac.githubexplorer.domain.interfaces.FeedRepository
import com.mac.githubexplorer.domain.interfaces.GitHubReposRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
class DataModule {

    @DataScope
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        Log.d(TAG, "creating an instance of OkHttpClientBuilder")
        return OkHttpClientBuilder().build()
    }

    @DataScope
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        Log.d(TAG, "creating an instance of RetrofitBuilder")
        return RetrofitBuilder(okHttpClient).build()
    }

    @DataScope
    @Provides
    fun provideGitHubReposService(retrofit: Retrofit): GitHubReposService {
        Log.d(TAG, "creating an instance of GitHubReposService")
        return retrofit.create(GitHubReposService::class.java)
    }

    @Provides
    fun provideRepoRemoteDataSource(gitHubReposService: GitHubReposService): RepoRemoteDataSource {
        Log.d(TAG, "creating an instance of RepoRemoteDataSource")
        return RepoRemoteDataSource(gitHubReposService)
    }

    @Provides
    fun provideGitHubRepoRepositoryImpl(repoRemoteDataSource: RepoRemoteDataSource): GitHubReposRepository {
        Log.d(TAG, "creating an instance of GitHubReposRepositoryImpl")
        return GitHubReposRepositoryImpl(repoRemoteDataSource)
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

    companion object {
        private const val TAG = "dagger-DataModule"
    }
}

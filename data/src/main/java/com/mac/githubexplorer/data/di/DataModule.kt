package com.mac.githubexplorer.data.di

import android.util.Log
import com.mac.githubexplorer.data.remote.OkHttpClientBuilder
import com.mac.githubexplorer.data.remote.RepoRemoteDataSource
import com.mac.githubexplorer.data.remote.RetrofitBuilder
import com.mac.githubexplorer.data.remote.api.GitHubReposService
import com.mac.githubexplorer.data.repositories.GitHubReposRepositoryImpl
import com.mac.githubexplorer.domain.repositories.GitHubReposRepository
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
        return OkHttpClientBuilder().okHttpClientInstance
    }

    @DataScope
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        Log.d(TAG, "creating an instance of RetrofitBuilder")
        return RetrofitBuilder(okHttpClient).retrofitInstance
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

    companion object {
        private const val TAG = "dagger-DataModule"
    }
}

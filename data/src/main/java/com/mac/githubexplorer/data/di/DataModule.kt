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
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
class DataModule {

    private val TAG = "dagger-DataModule"

    @DataScope
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        Log.d(TAG, "creando OkHttpClientBuilder")
        return OkHttpClientBuilder().okHttpClientInstance
    }

    @DataScope
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        Log.d(TAG, "creando RetrofitBuilder")
        return RetrofitBuilder(okHttpClient).retrofitInstance
    }

    @DataScope
    @Provides
    fun provideGitHubReposService(retrofit: Retrofit): GitHubReposService {
        Log.d(TAG, "creando GitHubReposService")
        return retrofit.create(GitHubReposService::class.java)
    }

    @Reusable
    @Provides
    fun provideRepoRemoteDataSource(gitHubReposService: GitHubReposService): RepoRemoteDataSource {
        Log.d(TAG, "creando RepoRemoteDataSource")
        return RepoRemoteDataSource(gitHubReposService)
    }

    @Reusable
    @Provides
    fun provideGitHubRepoRepositoryImpl(repoRemoteDataSource: RepoRemoteDataSource): GitHubReposRepository {
        Log.d(TAG, "creando GitHubReposRepositoryImpl")
        return GitHubReposRepositoryImpl(repoRemoteDataSource)
    }
}

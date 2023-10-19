package com.mac.githubexplorer.data.di

import android.content.Context
import androidx.room.Room
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mac.githubexplorer.data.interceptor.GitHubAuthInterceptor
import com.mac.githubexplorer.data.repositories.commons.local.GitHubDatabase
import com.mac.githubexplorer.data.repositories.commons.remote.api.GitHubReposService
import com.mac.githubexplorer.data.repositories.repo.local.datasource.dao.RepoDao
import com.mac.githubexplorer.data.repositories.user.local.datasource.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class DataModuleProvides {

    @BaseDevURL
    @Provides
    fun provideBaseURL(): String = "https://api.github.com/"

    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }

    @LogInterceptor
    @Provides
    fun provideLogInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BASIC)
        }
    }

    @AuthInterceptor
    @Provides
    fun provideAuthInterceptor(): Interceptor {
        return GitHubAuthInterceptor()
    }

    @Provides
    fun provideOkHttpClient(
        @AuthInterceptor authInterceptor: Interceptor,
        @LogInterceptor logInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(authInterceptor)
            addInterceptor(logInterceptor)
        }.build()
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson,
        @BaseDevURL baseURL: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideGitHubReposService(retrofit: Retrofit): GitHubReposService {
        return retrofit.create(GitHubReposService::class.java)
    }

    @Provides
    fun provideRoomDB(
        @ApplicationContext context: Context
    ): GitHubDatabase {
        return Room.databaseBuilder(
            context,
            GitHubDatabase::class.java, "gitHubDataBase-dev"
        ).build()
    }

    @Provides
    fun provideUserDao(
        db: GitHubDatabase
    ): UserDao {
        return db.userDao()
    }

    @Provides
    fun provideRepoDao(
        db: GitHubDatabase
    ): RepoDao {
        return db.repoDao()
    }
}

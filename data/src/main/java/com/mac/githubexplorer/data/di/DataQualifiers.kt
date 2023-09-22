package com.mac.githubexplorer.data.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseDevURL

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RemoteDataSourceQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LocalDataSourceQualifier
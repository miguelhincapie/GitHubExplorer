package com.mac.githubexplorer.presentation.ui.di

import com.mac.githubexplorer.presentation.presenter.di.PresenterModule
import com.mac.githubexplorer.presentation.ui.CreatePostActivity
import com.mac.githubexplorer.presentation.ui.FeedActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiBindingModule {

    @ContributesAndroidInjector(modules = [PresenterModule::class])
    internal abstract fun feedActivity(): FeedActivity

    @ContributesAndroidInjector(modules = [PresenterModule::class])
    internal abstract fun createPostActivity(): CreatePostActivity
}
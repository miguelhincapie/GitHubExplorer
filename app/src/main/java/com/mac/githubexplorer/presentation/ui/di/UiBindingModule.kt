package com.mac.githubexplorer.presentation.ui.di

import com.mac.githubexplorer.presentation.presenter.di.PresenterModule
import com.mac.githubexplorer.presentation.ui.CreatePostActivity
import com.mac.githubexplorer.presentation.ui.FeedActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

//@Module(subcomponents = [MainActivityComponent::class])
@Module
abstract class UiBindingModule {

//    @Binds
//    @IntoMap
//    @ClassKey(FeedActivity::class)
//    abstract fun bindMainActivityInjectorFactory(builder: MainActivityComponent.Factory):
//            AndroidInjector.Factory<*>

    @ContributesAndroidInjector(modules = [PresenterModule::class])
    internal abstract fun mainActivity(): FeedActivity

    @ContributesAndroidInjector(modules = [PresenterModule::class])
    internal abstract fun activity2(): CreatePostActivity
}
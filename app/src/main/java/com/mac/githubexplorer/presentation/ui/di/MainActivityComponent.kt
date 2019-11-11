package com.mac.githubexplorer.presentation.ui.di

import com.mac.githubexplorer.presentation.presenter.di.PresenterModule
import com.mac.githubexplorer.presentation.ui.FeedActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [PresenterModule::class])
interface MainActivityComponent : AndroidInjector<FeedActivity> {

    @Subcomponent.Builder
    abstract class Factory : AndroidInjector.Builder<FeedActivity>() {

        abstract fun injectMainActivityModule(presenterModule: PresenterModule): Factory

//        @BindsInstance
//        abstract fun plusGetRemoteStarredReposUseCase(getRemoteStarredReposUseCase: GetRemoteStarredReposUseCase): Factory
    }

//    @Subcomponent.Factory
//    interface Factory : AndroidInjector.Factory<FeedActivity> {
//        override fun create(instance: FeedActivity?): AndroidInjector<FeedActivity> {
//
//        }
//    }
}
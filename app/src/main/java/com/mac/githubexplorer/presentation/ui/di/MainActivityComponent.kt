package com.mac.githubexplorer.presentation.ui.di

import com.mac.githubexplorer.presentation.presenter.di.PresenterModule
import com.mac.githubexplorer.presentation.ui.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [PresenterModule::class])
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Factory : AndroidInjector.Builder<MainActivity>() {

        abstract fun injectMainActivityModule(presenterModule: PresenterModule): Factory

//        @BindsInstance
//        abstract fun plusGetRemoteStarredReposUseCase(getRemoteStarredReposUseCase: GetRemoteStarredReposUseCase): Factory
    }

//    @Subcomponent.Factory
//    interface Factory : AndroidInjector.Factory<MainActivity> {
//        override fun create(instance: MainActivity?): AndroidInjector<MainActivity> {
//
//        }
//    }
}
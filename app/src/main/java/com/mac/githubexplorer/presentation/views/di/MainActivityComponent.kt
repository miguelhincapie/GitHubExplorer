package com.mac.githubexplorer.presentation.views.di

import com.mac.githubexplorer.domain.usecases.GetRemoteStarredReposUseCase
import com.mac.githubexplorer.presentation.di.AppComponent
import com.mac.githubexplorer.presentation.views.MainActivity
import dagger.BindsInstance
import dagger.Component

@MainActivityScope
@Component(modules = [MainActivityModule::class], dependencies = [AppComponent::class])
interface MainActivityComponent {

    @Component.Builder
    interface Builder {
        fun build(): MainActivityComponent

        fun plusAppComponent(appComponent: AppComponent): Builder

        @BindsInstance
        fun plusGetRemoteStarredReposUseCase(getRemoteStarredReposUseCase: GetRemoteStarredReposUseCase): Builder
    }

    fun inject(mainActivity: MainActivity)
}
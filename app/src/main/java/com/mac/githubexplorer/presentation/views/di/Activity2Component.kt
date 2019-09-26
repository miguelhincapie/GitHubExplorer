package com.mac.githubexplorer.presentation.views.di

import com.mac.githubexplorer.presentation.di.AppComponent
import com.mac.githubexplorer.presentation.views.Activity2
import dagger.Component

@Activity2Scope
@Component(modules = [Activity2Module::class], dependencies = [AppComponent::class])
interface Activity2Component {

    @Component.Factory
    interface Factory {
        fun plus(appComponent: AppComponent): Activity2Component
    }

    fun inject(activity2: Activity2)
}
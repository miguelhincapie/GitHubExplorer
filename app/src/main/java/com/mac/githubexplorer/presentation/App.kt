package com.mac.githubexplorer.presentation

import android.app.Application
import com.mac.githubexplorer.presentation.di.DaggerAppComponent
import com.mac.githubexplorer.presentation.views.di.Activity2Component
import com.mac.githubexplorer.presentation.views.di.DaggerActivity2Component
import com.mac.githubexplorer.presentation.views.di.DaggerMainActivityComponent
import com.mac.githubexplorer.presentation.views.di.MainActivityComponent


class App : Application() {

    fun getMainActivityComponent(): MainActivityComponent {
        val appComponent = DaggerAppComponent
            .factory()
            .build(this)
        val dataComponent = appComponent
            .plusDataComponent()
            .build()
        val domainComponent = dataComponent
            .plusDomainComponent().build()
        return DaggerMainActivityComponent.builder()
            .plusAppComponent(appComponent)
            .plusGetRemoteStarredReposUseCase(domainComponent.provideGetRemoteStarredReposUseCase())
            .build()
    }

    fun getActivity2Component(): Activity2Component {
        val appComponent = DaggerAppComponent
            .factory()
            .build(this)
        return DaggerActivity2Component.factory()
            .plus(appComponent)
    }
}
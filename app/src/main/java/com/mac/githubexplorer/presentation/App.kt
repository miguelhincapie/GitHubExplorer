package com.mac.githubexplorer.presentation

import android.app.Application
import com.mac.githubexplorer.presentation.di.AppComponent
import com.mac.githubexplorer.presentation.di.DaggerAppComponent
import com.mac.githubexplorer.presentation.views.di.DaggerMainActivityComponent
import com.mac.githubexplorer.presentation.views.di.MainActivityComponent


class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()
    }

    fun getMainActivityComponent(): MainActivityComponent {
        val dataComponent = appComponent
            .plusDataComponent()
            .build()
        val domainComponent = dataComponent
            .plusDomainComponent()
            .build()
        return DaggerMainActivityComponent.builder()
            .plusAppComponent(appComponent)
            .plusGetRemoteStarredReposUseCase(domainComponent.provideGetRemoteStarredReposUseCase())
            .build()
    }
}
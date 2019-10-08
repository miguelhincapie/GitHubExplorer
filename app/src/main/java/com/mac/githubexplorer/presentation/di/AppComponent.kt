package com.mac.githubexplorer.presentation.di

import android.content.Context
import com.mac.githubexplorer.domain.di.DomainComponent
import com.mac.githubexplorer.presentation.App
import com.mac.githubexplorer.presentation.ui.di.UiBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

//@AppScope
@Component(
    modules = [AndroidInjectionModule::class, UiBindingModule::class],
    dependencies = [DomainComponent::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(app: App)

    @Component.Factory
    interface Factory {
        fun build(
            @BindsInstance context: Context,
            domainComponent: DomainComponent
        ): AppComponent
    }

    fun getContext(): Context
}
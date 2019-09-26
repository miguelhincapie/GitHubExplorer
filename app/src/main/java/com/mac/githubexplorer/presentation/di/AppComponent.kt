package com.mac.githubexplorer.presentation.di

import android.content.Context
import com.mac.githubexplorer.data.di.DataComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun build(@BindsInstance context: Context): AppComponent
    }

    fun getContext(): Context

    fun plusDataComponent(): DataComponent.Factory
}
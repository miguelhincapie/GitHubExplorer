package com.mac.githubexplorer.presentation.di

import android.app.Application
import com.mac.githubexplorer.data.di.DataComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
//@Component(modules = [AppModule::class], dependencies = [MainActivityComponent::class])
//@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
//@Component(modules = [AppModule::class, DomainModule::class])
@Component(modules = [AppModule::class])
//@Component(modules = [AppModule::class, DomainModule::class])
interface AppComponent {

//    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun plusDataComponent(): DataComponent.Builder
}
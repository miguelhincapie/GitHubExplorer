package com.mac.githubexplorer.presentation.ui.di

import com.mac.githubexplorer.presentation.presenter.di.PresenterModule
import com.mac.githubexplorer.presentation.ui.Activity2
import com.mac.githubexplorer.presentation.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

//@Module(subcomponents = [MainActivityComponent::class])
@Module
abstract class UiBindingModule {

//    @Binds
//    @IntoMap
//    @ClassKey(MainActivity::class)
//    abstract fun bindMainActivityInjectorFactory(builder: MainActivityComponent.Factory):
//            AndroidInjector.Factory<*>

    @ContributesAndroidInjector(modules = [PresenterModule::class])
    internal abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [PresenterModule::class])
    internal abstract fun activity2(): Activity2
}
package com.mac.githubexplorer.data.di

import com.mac.githubexplorer.domain.interfaces.FeedRepository
import dagger.Component

@DataScope
@Component(modules = [DataModule::class])
interface DataComponent {

    @Component.Factory
    interface Factory {
        fun build(): DataComponent
    }

    fun provideFeedRepository(): FeedRepository
}
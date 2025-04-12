package com.application.tasksapp

import android.app.Application
import com.application.di.scope.AppScope
import com.squareup.anvil.annotations.MergeComponent
import com.squareup.anvil.annotations.optional.SingleIn
import dagger.BindsInstance
import dagger.Component

@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: Application,
        ): AppComponent
    }

    fun inject(app: Application)

    fun inject(activity: MainActivity)
}
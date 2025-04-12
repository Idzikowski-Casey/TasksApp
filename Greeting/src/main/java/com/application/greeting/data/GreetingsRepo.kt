package com.application.greeting.data

import android.app.Application
import com.application.di.scope.AppScope
import com.application.greeting.GreetingInfo
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

interface GreetingsRepository {
    fun getGreetings(value: String? = null): GreetingInfo
}

@ContributesBinding(AppScope::class)
class GreetingsRepositoryImpl @Inject constructor(
    private val application: Application,
) : GreetingsRepository {
    override fun getGreetings(value: String?): GreetingInfo {
        val contextName = "$value ${application.applicationInfo.name}"
        val appName = application.applicationContext.packageName
        return GreetingInfo(
            name = contextName,
            greeting = "Hello from $appName"
        )
    }
}
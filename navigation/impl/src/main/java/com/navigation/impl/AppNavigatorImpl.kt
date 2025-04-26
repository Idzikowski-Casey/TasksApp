package com.navigation.impl

import com.application.di.scope.AppScope
import com.navigation.api.AppNavigator
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class AppNavigatorImpl @Inject constructor(): AppNavigator {
    override fun navigateTo(route: String) {
    }
}
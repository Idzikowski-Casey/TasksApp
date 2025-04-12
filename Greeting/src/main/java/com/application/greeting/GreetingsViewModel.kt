package com.application.greeting

import androidx.lifecycle.ViewModel
import com.application.di.scope.AppScope
import com.application.di.viewmodel.ViewModelKey
import com.application.greeting.data.GreetingsRepository
import com.squareup.anvil.annotations.ContributesMultibinding
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow

@ContributesMultibinding(AppScope::class, boundType = ViewModel::class)
@ViewModelKey(GreetingsViewModel::class)
class GreetingsViewModel @Inject constructor(
    private val greetingsRepository: GreetingsRepository
): ViewModel() {

    internal val state = MutableStateFlow(GreetingInfo())

    init {
        val greeting = greetingsRepository.getGreetings()
        state.value = greeting
    }

    fun getGreetings(): MutableStateFlow<GreetingInfo> {
        return state
    }

    fun onClick() {
        val greeting = greetingsRepository.getGreetings("Android")
        state.value = greeting
    }
}

data class GreetingInfo(
    val name: String? = null,
    val greeting: String? = null
)
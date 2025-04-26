package com.data.api

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class ScreenState(
    val isLoading: Boolean = true,
    val models: StateFlow<List<BaseModel>> = MutableStateFlow(emptyList())
)
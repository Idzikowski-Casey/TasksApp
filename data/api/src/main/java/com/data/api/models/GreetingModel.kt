package com.data.api.models

import androidx.compose.runtime.Immutable
import com.data.api.BaseModel

@Immutable
data class GreetingModel(
    val title: String,
    val subtitle: String
) : BaseModel()
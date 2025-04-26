package com.viewRenderer.api

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.data.api.BaseModel


/**
 * A base interface for all ViewRenderers within the app. Bound to a single
 * [BaseModel] type.
 *
 * Each renderer implements a single composable function by taking in the [BaseModel]
 */
interface ViewRenderer<T: BaseModel> {

    @Composable
    fun Render(model: T, modifier: Modifier)
}
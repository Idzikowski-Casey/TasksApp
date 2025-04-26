package com.application.greeting

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.data.api.models.GreetingModel
import com.ux.components.greeting.GreetingCompose
import com.viewRenderer.api.ViewRenderer
import javax.inject.Inject

class GreetingViewRenderer @Inject constructor(): ViewRenderer<GreetingModel> {
    @Composable
    override fun Render(model: GreetingModel, modifier: Modifier) {
        GreetingCompose(model, modifier)
    }
}
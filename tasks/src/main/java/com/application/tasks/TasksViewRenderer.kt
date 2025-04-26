package com.application.tasks

import androidx.compose.runtime.Composable
import com.application.di.scope.AppScope
import com.data.api.models.TasksModel
import com.squareup.anvil.annotations.ContributesMultibinding
import com.viewRenderer.api.ViewRenderer
import com.viewRenderer.api.ViewRendererKey
import javax.inject.Inject

class TasksViewRenderer @Inject constructor(): ViewRenderer<TasksModel> {

    @Composable
    override fun Render(model: TasksModel) {
        // TODO
    }
}
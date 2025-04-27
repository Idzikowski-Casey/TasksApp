package com.application.tasks

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.data.api.models.TasksUIModel
import com.ux.components.tasks.TasksCompose
import com.viewRenderer.api.ViewRenderer
import javax.inject.Inject

class TasksViewRenderer @Inject constructor(): ViewRenderer<TasksUIModel> {

    @Composable
    override fun Render(model: TasksUIModel, modifier: Modifier) {
        TasksCompose(model, modifier)
    }
}
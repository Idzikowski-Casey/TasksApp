package com.ux.components.tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.data.api.models.TaskModel
import com.data.api.models.TaskStatus
import com.data.api.models.TaskUIModel
import com.data.api.models.TasksUIModel
import com.ux.components.dimensions.TaskDimensions
import com.ux.components.theme.TasksAppTheme

@Composable
fun TasksCompose(model: TasksUIModel, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(TaskDimensions.s4.value)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(TaskDimensions.s2.value),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        model.tasks.forEach {
            TaskCompose(it)
        }
        if (model.shouldShowAddTask) {
            AddTaskCompose(model.onAddTask)
        }
    }
}

@Composable
fun AddTaskCompose(onAddTask: () -> Unit) {

    TaskContainerCompose(Modifier) {
        IconButton (
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .heightIn(max = TaskDimensions.s8.value)
                .fillMaxWidth(),
            onClick = onAddTask,
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add")
        }
    }
}

@Preview
@Composable
fun TasksComposePreview() {
    val tasks = TasksUIModel(
        tasks = listOf(
            TaskUIModel(
                task = TaskModel("Title", "Description", TaskStatus.COMPLETED, 1),
                onDelete = {}
            ),
            TaskUIModel(
                task = TaskModel("Title", "Description", TaskStatus.PENDING, 2),
                onDelete = {}
            ),
            TaskUIModel(
                task = TaskModel("Title", "Description", TaskStatus.IN_PROGRESS, 3),
                onDelete = {}
            ),
            TaskUIModel(
                task = TaskModel("Title", "Description", TaskStatus.NOT_STARTED, 4),
                onDelete = {}
            )
        )
    )

    TasksAppTheme {
        TasksCompose(tasks)
    }
}
package com.ux.components.tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.data.api.models.TaskModel
import com.data.api.models.TasksModel
import com.ux.components.dimensions.TaskDimensions
import com.data.api.models.TaskStatus
import com.ux.components.theme.TasksAppTheme

@Composable
fun TasksCompose(model: TasksModel, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(TaskDimensions.s4.value).fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(TaskDimensions.s2.value),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        model.tasks.forEach {
            TaskCompose(it.value)
        }
    }
}

@Preview
@Composable
fun TasksComposePreview() {
    val tasks = TasksModel(
        mapOf(
            Pair(
                "1", TaskModel(
                    "Task 1", "This is the first task",
                    TaskStatus.NEW, "1"
                )
            ),
            Pair(
                "2", TaskModel(
                    "Task 2", "This is the second task",
                    TaskStatus.IN_PROGRESS, "2"
                )
            ),
            Pair(
                "3", TaskModel(
                    "Task 3", "This is the third Task",
                    TaskStatus.PENDING, "3"
                )
            ),
            Pair(
                "4", TaskModel(
                    "Task 4", "This is the fourth Task",
                    TaskStatus.COMPLETED, "4"
                )
            )
        )
    )

    TasksAppTheme {
        TasksCompose(tasks)
    }
}
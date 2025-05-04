package com.ux.components.tasks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.data.api.models.TaskModel
import com.data.api.models.TaskStatus
import com.data.api.models.TaskUIModel
import com.ux.components.dimensions.TaskDimensions
import com.ux.components.theme.TasksAppTheme

@Composable
fun TaskCompose(data: TaskUIModel, modifier: Modifier = Modifier) {
    TaskContainerCompose(modifier) {
        Box(
            Modifier
                .padding(TaskDimensions.s2.value)
                .fillMaxWidth()
        ) {
            TaskInfo(title = data.task.title, description = data.task.description)
            Row(Modifier.align(Alignment.CenterEnd)) {
                TaskStatus(
                    status = data.task.status,
                    isStatusMenuShown = data.isStatusMenuShown,
                    onStatusSelect = data.onStatusSelect,
                    onStatusDismiss = data.onStatusDismiss,
                    onStatusChange = data.onStatusChange
                )
                TasksDeleteCompose(
                    taskTitle = data.task.title,
                    isDeleteDialogShown = data.isDeleteDialogShown,
                    onDeleteConfirm = data.onDeleteConfirm,
                    onDeleteDismiss = data.onDeleteDismiss,
                    onDelete = data.onDelete
                )
            }
        }
    }
}

@Composable
fun TaskInfo(modifier: Modifier = Modifier, title: String, description: String) {
    Column(modifier) {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        Text(text = description, style = MaterialTheme.typography.bodyMedium)
    }
}


@Preview
@Composable
fun TaskComposePreview() {
    val data = TaskUIModel(
        task = TaskModel("Title", "Description", TaskStatus.COMPLETED, 1),
        onDelete = {}
    )

    TasksAppTheme {
        Box(
            modifier = Modifier
                .padding(TaskDimensions.s4.value)
                .fillMaxWidth()
        ) {
            TaskCompose(data)
        }
    }
}
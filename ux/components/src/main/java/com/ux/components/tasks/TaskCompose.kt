package com.ux.components.tasks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.data.api.models.TaskEditUIModel
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
            TaskInfo(
                title = data.task.title,
                description = data.task.description,
                editDetails = data.detailsEdit
            )
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
fun TaskInfo(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    editDetails: TaskEditUIModel,
) {
    Column(modifier) {
        Row {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.widthIn(max = TaskDimensions.s120.value)
                )
            TaskEditCompose(
                modifier = Modifier
                    .padding(start = TaskDimensions.s2.value)
                    .size(TaskDimensions.s5.value),
                taskTitle = editDetails.currentTitle,
                taskDescription = editDetails.currentDescription,
                onSave = editDetails.onSave,
                isEditDialogShown = editDetails.isEditDialogShown,
                onEditDismiss = editDetails.onEditDismiss,
                onEdit = editDetails.onEdit
            )
        }
        Text(
            text = description,
            modifier = Modifier.width(TaskDimensions.s200.value),
            maxLines = 2,
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Preview
@Composable
fun TaskComposePreview() {
    val description = "This is the long description for the task at hand"
    val data = TaskUIModel(
        task = TaskModel("Title", description, TaskStatus.COMPLETED, 1),
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
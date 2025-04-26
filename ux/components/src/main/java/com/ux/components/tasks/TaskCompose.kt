package com.ux.components.tasks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.data.api.models.TaskModel
import com.data.api.models.TaskStatus
import com.ux.components.dimensions.TaskDimensions
import com.ux.components.theme.TasksAppTheme

@Composable
fun TaskCompose(data: TaskModel, modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth(.80f),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = TaskDimensions.s2.value
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        )
    ) {
        Box(
            Modifier
                .padding(TaskDimensions.s2.value)
                .fillMaxWidth()
        ) {
            TaskInfo(title = data.title, description = data.description)
            TasksDeleteCompose(modifier = Modifier.align(Alignment.TopEnd), onDelete = {})
            TaskStatus(modifier = Modifier.align(Alignment.BottomEnd), status = data.status)
        }
    }
}

@Composable
fun TaskInfo(modifier: Modifier = Modifier,title: String, description: String) {
    Column(modifier) {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        Text(text = description, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun TaskStatus(modifier: Modifier = Modifier, status: TaskStatus) {
    val buttonColors = ButtonColors(
        containerColor = TaskColors.getContainerColorForStatus(status),
        contentColor = TaskColors.getContentColorForStatus(status),
        disabledContainerColor = TaskColors.getContainerColorForStatus(status),
        disabledContentColor = TaskColors.getContentColorForStatus(status),
    )
    FilledTonalButton(
        modifier = modifier.heightIn(max = TaskDimensions.s5.value),
        shape = RoundedCornerShape(TaskDimensions.s2.value),
        contentPadding = PaddingValues(horizontal = TaskDimensions.s2.value),
        colors = buttonColors,
        onClick = {}
    ) {
        Text(
            text = status.value,
            style = MaterialTheme.typography.labelSmall
        )
    }
}


@Preview
@Composable
fun TaskComposePreview() {
    TasksAppTheme {
        Box(modifier = Modifier
            .padding(TaskDimensions.s4.value)
            .fillMaxWidth()) {
            TaskCompose(TaskModel("Title", "Description", TaskStatus.COMPLETED, "1"))
        }
    }
}
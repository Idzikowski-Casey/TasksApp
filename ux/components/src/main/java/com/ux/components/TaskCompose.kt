package com.ux.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ux.components.dimensions.TaskDimensions

enum class TaskStatus {
    NEW,
    IN_PROGRESS,
    PENDING,
    COMPLETED
}

@Immutable
data class TaskData(
    val title: String,
    val description: String,
    val status: TaskStatus,
    val id: String
)

@Composable
fun TaskCompose(data: TaskData){
    Column(Modifier.padding(TaskDimensions.s2.value)) {
        Text(text = data.title)
        Text(text = data.description)
        Text(text = data.status.name)
    }
}

@Preview
@Composable
fun TaskComposePreview(){
    TaskCompose(TaskData("Title", "Description", TaskStatus.NEW, "1"))
}
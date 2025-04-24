package com.data.api.models

import androidx.compose.runtime.Immutable
import com.data.api.BaseModel

@Immutable
enum class TaskStatus {
    NEW,
    IN_PROGRESS,
    PENDING,
    COMPLETED
}

@Immutable
data class TaskModel(
    val title: String,
    val description: String,
    val status: TaskStatus,
    val id: String
): BaseModel()

@Immutable
data class TasksModel(
    val tasks: List<TaskModel>
) : BaseModel()
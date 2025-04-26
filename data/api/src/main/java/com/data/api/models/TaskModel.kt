package com.data.api.models

import androidx.compose.runtime.Immutable
import com.data.api.BaseModel

@Immutable
enum class TaskStatus(val value: String) {
    NEW("New"),
    IN_PROGRESS("In Progress"),
    PENDING("Pending"),
    COMPLETED("Completed")
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
    val tasks: Map<TaskId, TaskModel>
) : BaseModel()

typealias TaskId = String
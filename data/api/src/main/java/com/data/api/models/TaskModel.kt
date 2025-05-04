package com.data.api.models

import androidx.compose.runtime.Immutable
import com.data.api.BaseModel

// region business models

@Immutable
enum class TaskStatus(val value: String) {
    NOT_STARTED("Not Started"),
    IN_PROGRESS("In Progress"),
    PENDING("Pending"),
    COMPLETED("Completed")
}

@Immutable
data class TaskModel(
    val title: String,
    val description: String,
    val status: TaskStatus,
    val id: Int
): BaseModel()

@Immutable
data class TasksModel(
    val tasks: Map<TaskId, TaskModel>
) : BaseModel()

typealias TaskId = Int

// endregion
// region UI Models

@Immutable
data class TaskUIModel(
    val task: TaskModel,
    val isDeleteDialogShown: Boolean = false,
    val isStatusMenuShown: Boolean = false,
    val onDelete: () -> Unit = {},
    val onDeleteConfirm: () -> Unit = {},
    val onDeleteDismiss: () -> Unit = {},
    val onStatusSelect: () -> Unit = {},
    val onStatusDismiss: () -> Unit = {},
    val onStatusChange: (TaskStatus) -> Unit = {}
) : BaseModel()

@Immutable
data class TasksUIModel(
    val tasks: List<TaskUIModel>,
    val shouldShowAddTask: Boolean = true,
    val onAddTask: () -> Unit = {}
) : BaseModel()

// endregion

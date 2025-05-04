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
) : BaseModel()

@Immutable
data class TasksModel(
    val tasks: Map<TaskId, TaskModel>
) : BaseModel()

typealias TaskId = Int

// endregion
// region UI Models

/**
 * Model for the Task UI - supports Deletion of task and
 * changing of Status.
 */
@Immutable
data class TaskUIModel(
    val task: TaskModel,
    val detailsEdit: TaskEditUIModel = TaskEditUIModel(),
    val isDeleteDialogShown: Boolean = false,
    val isStatusMenuShown: Boolean = false,
    val onDelete: () -> Unit = {},
    val onDeleteConfirm: () -> Unit = {},
    val onDeleteDismiss: () -> Unit = {},
    val onStatusSelect: () -> Unit = {},
    val onStatusDismiss: () -> Unit = {},
    val onStatusChange: (TaskStatus) -> Unit = {}
) : BaseModel()

/**
 * A specific model to be used for the Task Details editing for:
 * Title
 * Description
 */
@Immutable
data class TaskEditUIModel(
    val currentTitle: String = "",
    val currentDescription: String = "",
    val onCancel: () -> Unit = {},
    val onSave: (title: String, description: String) -> Unit = { _, _ -> },
    val isEditDialogShown: Boolean = false,
    val onEdit: () -> Unit = {},
    val onEditDismiss: () -> Unit = {},
) : BaseModel()

/**
 * Aggregate Tasks UI model. Supports adding a new task
 */
@Immutable
data class TasksUIModel(
    val tasks: List<TaskUIModel>,
    val shouldShowAddTask: Boolean = true,
    val onAddTask: () -> Unit = {}
) : BaseModel()

// endregion

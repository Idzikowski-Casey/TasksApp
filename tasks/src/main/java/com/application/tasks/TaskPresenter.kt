package com.application.tasks

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.data.api.BaseModel
import com.data.api.datasource.TasksDataSource
import com.data.api.models.TaskModel
import com.data.api.models.TaskUIModel
import com.molecule_presenter.api.Presenter
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class TaskPresenter @Inject constructor(
    private val tasksDataSource: TasksDataSource
) : Presenter<TaskModel> {
    @Composable
    override fun present(scope: CoroutineScope, model: TaskModel): BaseModel {
        var isDeleteDialogShown by remember { mutableStateOf(false) }
        var isStatusMenuShown by remember { mutableStateOf(false) }

        return TaskUIModel(
            task = model,
            isDeleteDialogShown = isDeleteDialogShown,
            isStatusMenuShown = isStatusMenuShown,
            onDelete = {
                isDeleteDialogShown = true
            },
            onDeleteConfirm = {
                isDeleteDialogShown = false
                tasksDataSource.deleteTask(model.id)
            },
            onDeleteDismiss = {
                isDeleteDialogShown = false
            },
            onStatusSelect = {
                isStatusMenuShown = true
            },
            onStatusDismiss = {
                isStatusMenuShown = false
            },
            onStatusChange = {
                isStatusMenuShown = false
                val newModel = model.copy(status = it)
                tasksDataSource.updateTask(newModel)
            }
        )
    }
}
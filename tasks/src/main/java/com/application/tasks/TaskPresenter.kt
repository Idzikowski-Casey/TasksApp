package com.application.tasks

import androidx.compose.runtime.Composable
import com.data.api.BaseModel
import com.data.api.datasource.TasksDataSource
import com.data.api.models.TaskModel
import com.data.api.models.TaskUIModel
import com.molecule_presenter.api.Presenter
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class TaskPresenter @Inject constructor(
    private val tasksDataSource: TasksDataSource
): Presenter<TaskModel> {
    @Composable
    override fun present(scope: CoroutineScope, model: TaskModel): BaseModel {
        return TaskUIModel(
            task = model,
            onDelete = {
                tasksDataSource.deleteTask(model.id)
            }
        )
    }
}
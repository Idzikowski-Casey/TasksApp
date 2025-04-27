package com.application.tasks

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.data.api.BaseModel
import com.data.api.datasource.TasksDataSource
import com.data.api.models.TaskModel
import com.data.api.models.TaskStatus
import com.data.api.models.TaskUIModel
import com.data.api.models.TasksModel
import com.data.api.models.TasksUIModel
import com.molecule_presenter.api.Presenter
import com.molecule_presenter.api.PresenterFactory
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class TasksPresenter @Inject constructor(
    private val presenterFactory: PresenterFactory,
    private val tasksDataSource: TasksDataSource
) : Presenter<TasksModel> {

    @Composable
    override fun present(scope: CoroutineScope, model: TasksModel): BaseModel {
        val tasksModel by tasksDataSource.observeTasks().collectAsState()

        LaunchedEffect(model) {
            tasksDataSource.updateTasks(model)
        }

        return TasksUIModel(
            tasks = tasksModel.tasks.map { (_, task) ->
                val presenter: Presenter<TaskModel>? = presenterFactory.createPresenter(task)
                return@map presenter?.present(scope, task) as? TaskUIModel
            }.filterNotNull(),
            onAddTask = {
                val newTask = TaskModel(
                    title = "New Task",
                    description = "New Description",
                    status = TaskStatus.NOT_STARTED,
                    id = 0
                )

                tasksDataSource.addTask(newTask)
            }
        )
    }
}
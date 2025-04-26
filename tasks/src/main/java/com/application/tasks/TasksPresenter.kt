package com.application.tasks

import androidx.compose.runtime.Composable
import com.data.api.BaseModel
import com.data.api.models.TaskModel
import com.data.api.models.TasksModel
import com.molecule_presenter.api.Presenter
import com.molecule_presenter.api.PresenterFactory
import javax.inject.Inject

class TasksPresenter @Inject constructor(
    private val presenterFactory: PresenterFactory,
): Presenter<TasksModel> {

    @Composable
    override fun present(model: TasksModel): BaseModel {

        return TasksModel(
            tasks = model.tasks.mapValues { (id, task) ->
                val presenter: Presenter<TaskModel>? = presenterFactory.createPresenter(task)
                return@mapValues presenter?.present(task) as? TaskModel ?: task
            }
        )
    }
}
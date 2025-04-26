package com.application.tasks

import androidx.compose.runtime.Composable
import com.data.api.BaseModel
import com.data.api.models.TaskModel
import com.molecule_presenter.api.Presenter
import javax.inject.Inject

class TaskPresenter @Inject constructor(): Presenter<TaskModel> {
    @Composable
    override fun present(model: TaskModel): BaseModel {
        return model
    }
}
package com.application.tasks

import androidx.compose.runtime.Composable
import com.application.di.scope.AppScope
import com.data.api.BaseModel
import com.data.api.models.TaskModel
import com.molecule_presenter.api.Presenter
import com.molecule_presenter.api.PresenterKey
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(AppScope::class, boundType = Presenter::class)
@PresenterKey(TaskModel::class)
class TaskPresenter @Inject constructor(): Presenter<TaskModel> {
    @Composable
    override fun present(model: TaskModel): BaseModel {
        return model
    }
}
package com.application.tasks.di

import com.application.di.scope.AppScope
import com.application.tasks.TaskPresenter
import com.application.tasks.TasksPresenter
import com.application.tasks.TasksViewRenderer
import com.data.api.BaseModel
import com.data.api.models.TaskModel
import com.data.api.models.TasksModel
import com.data.api.models.TasksUIModel
import com.molecule_presenter.api.Presenter
import com.molecule_presenter.api.PresenterKey
import com.squareup.anvil.annotations.ContributesTo
import com.viewRenderer.api.ViewRenderer
import com.viewRenderer.api.ViewRendererKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
@ContributesTo(AppScope::class)
abstract class TasksModule {

    @Binds
    @IntoMap
    @PresenterKey(TasksModel::class)
    abstract fun bindsTasksPresenter(tasksPresenter: TasksPresenter): Presenter<out BaseModel>

    @Binds
    @IntoMap
    @PresenterKey(TaskModel::class)
    abstract fun bindsTaskPresenter(taskPresenter: TaskPresenter): Presenter<out BaseModel>

    @Binds
    @IntoMap
    @ViewRendererKey(TasksUIModel::class)
    abstract fun bindsTasksViewRenderer(tasksViewRenderer: TasksViewRenderer): ViewRenderer<out BaseModel>
}
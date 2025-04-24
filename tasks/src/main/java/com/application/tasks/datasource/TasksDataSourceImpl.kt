package com.application.tasks.datasource

import com.application.di.scope.AppScope
import com.data.api.datasource.TasksDataSource
import com.data.api.models.TaskModel
import com.data.api.models.TasksModel
import com.squareup.anvil.annotations.ContributesBinding
import com.squareup.anvil.annotations.optional.SingleIn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class)
class TasksDataSourceImpl @Inject constructor(): TasksDataSource {
    
    private val tasks = MutableStateFlow(TasksModel(emptyMap()))

    override fun getTasks(): StateFlow<TasksModel> {
        TODO()
    }

    override fun getTask(id: String): StateFlow<TaskModel> {
        TODO("Not yet implemented")
    }

    override fun addTask(task: TaskModel) {
        TODO()
    }

    override fun deleteTask(id: String) {
        TODO("Not yet implemented")
    }

    override fun updateTask(task: TaskModel) {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }
}
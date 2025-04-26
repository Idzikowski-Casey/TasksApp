package com.application.tasks.datasource

import com.application.di.scope.AppScope
import com.data.api.datasource.TasksDataSource
import com.data.api.models.TaskModel
import com.data.api.models.TasksModel
import com.squareup.anvil.annotations.ContributesBinding
import com.squareup.anvil.annotations.optional.SingleIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class)
class TasksDataSourceImpl @Inject constructor() : TasksDataSource {

    private val tasks = MutableStateFlow(TasksModel(emptyMap()))

    override fun observeTasks(): StateFlow<TasksModel> = tasks

    override fun observeTask(id: String): Flow<TaskModel> {
        return tasks.transform { it.tasks[id]?.let { emit(it) } }
    }

    override fun getTasks(): TasksModel = tasks.value

    override fun getTask(id: String): TaskModel? = tasks.value.tasks[id]

    override fun addTask(task: TaskModel) {
        tasks.value = tasks.value.copy(tasks = tasks.value.tasks + (task.id to task))
    }

    override fun deleteTask(id: String) {
        tasks.value = tasks.value.copy(tasks = tasks.value.tasks - id)
    }

    override fun updateTask(task: TaskModel) {
        val newTasks = tasks.value.copy().tasks.toMutableMap()
        newTasks[task.id] = task
        tasks.value = tasks.value.copy(tasks = newTasks)
    }

    override fun clear() {
        tasks.value = TasksModel(emptyMap())
    }
}
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

    override fun observeTask(id: Int): Flow<TaskModel> {
        return tasks.transform { it.tasks[id]?.let { emit(it) } }
    }

    override fun getTasks(): TasksModel = tasks.value

    override fun getTask(id: Int): TaskModel? = tasks.value.tasks[id]

    override fun addTask(task: TaskModel) {
        // calculate new id if adding task id is taken already
        val id = getNextId(tasks.value).takeIf { task.id in tasks.value.tasks } ?: task.id

        val newTask = task.copy(id = id)
        tasks.value = tasks.value.copy(tasks = tasks.value.tasks + (newTask.id to newTask))
    }

    override fun deleteTask(id: Int) {
        tasks.value = tasks.value.copy(tasks = tasks.value.tasks - id)
    }

    override fun updateTask(task: TaskModel) {
        val newTasks = tasks.value.copy().tasks.toMutableMap()
        newTasks[task.id] = task
        tasks.value = tasks.value.copy(tasks = newTasks)
    }

    override fun updateTasks(tasksModel: TasksModel) {
        clear()
        tasksModel.tasks.forEach {
            addTask(it.value)
        }
    }

    override fun clear() {
        tasks.value = TasksModel(emptyMap())
    }

    private fun getNextId(tasks: TasksModel): Int? {
        return tasks.tasks.keys.maxByOrNull { it }?.plus(1)
    }
}
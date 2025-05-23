package com.data.api.datasource

import com.data.api.models.TaskModel
import com.data.api.models.TasksModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

/**
 * An in-memory Data source for tasks. Stores all tasks the user has created during app session.
 */
interface TasksDataSource {

    /**
     * Returns all current tasks the user has created as
     * observable stateFlow
     */
    fun observeTasks(): StateFlow<TasksModel>

    /**
     * Returns a single task by its id as observable stateFlow.
     * @param id The id of the task to retrieve.
     */
    fun observeTask(id: Int): Flow<TaskModel>

    /**
     * Returns all current tasks the user has created.
     */
    fun getTasks(): TasksModel

    /**
     * Returns a single task by its id.
     * @param id The id of the task to retrieve.
     */
    fun getTask(id: Int): TaskModel?

    /**
     * Adds a new task to the data source.
     * @param task The task to add.
     */
    fun addTask(task: TaskModel)

    /**
     * Deletes a task from the data source.
     * @param id The id of the task to delete.
     */
    fun deleteTask(id: Int)

    /**
     * Updates a task in the data source.
     * @param task The task to update.
     */
    fun updateTask(task: TaskModel)


    /**
     * A bulk update for tasks. Generally used only once per app session.
     */
    fun updateTasks(tasksModel: TasksModel)

    /**
     * Clears all tasks from the data source.
     */
    fun clear()
}
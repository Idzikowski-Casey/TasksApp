package com.data.api.datasource

import com.data.api.models.TaskModel
import com.data.api.models.TasksModel

/**
 * An in-memory Data source for tasks. Stores all tasks the user has created during app session.
 */
interface TasksDataSource {

    /**
     * Returns all tasks the user has created.
     */
    fun getTasks(): TasksModel

    /**
     * Returns a single task by its id.
     * @param id The id of the task to retrieve.
     */
    fun getTask(id: String): TaskModel

    /**
     * Adds a new task to the data source.
     * @param task The task to add.
     */
    fun addTask(task: TaskModel)

    /**
     * Deletes a task from the data source.
     * @param id The id of the task to delete.
     */
    fun deleteTask(id: String)

    /**
     * Updates a task in the data source.
     * @param task The task to update.
     */
    fun updateTask(task: TaskModel)

    /**
     * Clears all tasks from the data source.
     */
    fun clear()
}
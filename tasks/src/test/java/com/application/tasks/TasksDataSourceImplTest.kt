package com.application.tasks

import app.cash.turbine.test
import com.application.tasks.datasource.TasksDataSourceImpl
import com.data.api.models.TaskModel
import com.data.api.models.TaskStatus
import com.data.api.models.TasksModel
import io.kotest.matchers.maps.shouldNotHaveKey
import kotlinx.coroutines.test.runTest
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TasksDataSourceImplTest {

    val dataSource = TasksDataSourceImpl()

    @Test
    fun `test addTask and clearTasks, with tasks, emits expected tasks`() = runTest {
        dataSource.observeTasks().test {
            assert(awaitItem().tasks.isEmpty())

            tasks.forEach { dataSource.addTask(it) }

            val emission = awaitItem()
            assert(emission.tasks.size == 1)
            assert(emission.tasks[ID_1] == tasks[0])

            val emissionTwo = awaitItem()
            assert(emissionTwo.tasks.size == 2)
            assert(emissionTwo.tasks[ID_2] == tasks[1])

            val emissionThree = awaitItem()
            assert(emissionThree.tasks.size == 3)
            assert(emissionThree.tasks[ID_3] == tasks[2])

            dataSource.clear()
            assert(awaitItem().tasks.isEmpty())
        }
    }

    @Test
    fun `test addTask and deleteTask, with tasks, emits expected tasks`() = runTest {
        dataSource.observeTasks().test {
            assert(awaitItem().tasks.isEmpty())

            tasks.forEach { dataSource.addTask(it) }

            val emission = awaitItem()
            assert(emission.tasks.size == 1)
            assert(emission.tasks[ID_1] == tasks[0])
            awaitItem()
            awaitItem()

            dataSource.deleteTask(ID_1)

            val emissionTwo = awaitItem()
            assert(emissionTwo.tasks.size == 2)
            emissionTwo.tasks shouldNotHaveKey ID_1

            dataSource.clear()
            assert(awaitItem().tasks.isEmpty())
        }
    }

    @Test
    fun `test addTask and updateTask, with tasks, emits expected tasks`() = runTest {

        tasks.forEach { dataSource.addTask(it) }

        dataSource.observeTask(ID_2).test {
            val item = awaitItem()
            assert(item.title == TITLE)

            val updatedTask = item.copy(title = UPDATED_TITLE)
            dataSource.updateTask(updatedTask)
            assert(awaitItem().title == UPDATED_TITLE)
        }

        dataSource.clear()
    }

    @Test
    fun `test updateTasks, with tasks, emits expected tasks`() = runTest {
        dataSource.observeTasks().test {
            assert(awaitItem().tasks.isEmpty())

            dataSource.updateTasks(TasksModel(tasks.associateBy { it.id }))
            awaitItem()
            awaitItem()
            assert(awaitItem().tasks.size == 3)
        }
        dataSource.clear()
    }

    @Test
    fun `test addTask, with a repeating id, task id is changed`() = runTest {
        dataSource.observeTasks().test {
            assert(awaitItem().tasks.isEmpty())
            tasks.forEach { dataSource.addTask(it) }
            awaitItem()
            awaitItem()

            val taskModel = awaitItem()
            assert(taskModel.tasks.size == 3)
            assert(ID_3 in taskModel.tasks)

            // add task with same id as last item
            dataSource.addTask(TaskModel(TITLE, DESC, STATUS, ID_3))
            val updatedTasks = awaitItem()
            assert(updatedTasks.tasks.size == 4)
            assert(ID_4 in updatedTasks.tasks)
        }
        dataSource.clear()
    }

    companion object {
        const val TITLE = "title"
        const val DESC = "desc"
        val STATUS = TaskStatus.NOT_STARTED
        const val ID_1 = 1
        const val ID_2 = 2
        const val ID_3 = 3
        const val ID_4 = 4

        const val UPDATED_TITLE = "updatedTitle"

        val tasks = listOf(
            TaskModel(TITLE, DESC, STATUS, ID_1),
            TaskModel(TITLE, DESC, STATUS, ID_2),
            TaskModel(TITLE, DESC, STATUS, ID_3)
        )
    }
}
package com.application.tasksscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.di.scope.AppScope
import com.application.di.viewmodel.ViewModelKey
import com.data.api.BaseModel
import com.data.api.ScreenState
import com.data.api.models.GreetingModel
import com.data.api.models.TaskModel
import com.data.api.models.TaskStatus
import com.data.api.models.TasksModel
import com.molecule_presenter.api.RootPresenter
import com.squareup.anvil.annotations.ContributesMultibinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ContributesMultibinding(AppScope::class, boundType = ViewModel::class)
@ViewModelKey(TasksScreenViewModel::class)
class TasksScreenViewModel @Inject constructor(
    private val rootPresenter: RootPresenter
) : ViewModel() {
    private val screenState = MutableStateFlow(ScreenState())

    fun observeScreenState(): MutableStateFlow<ScreenState> {
        return screenState.also {
            // if empty we refresh screen
            if (screenState.value.models.value.isEmpty()) {
                viewModelScope.launch {
                    loadData()
                }
            }
        }
    }

    private suspend fun loadData() {
        delay(1000)
        screenState.value = screenState.value.copy(
            isLoading = false,
            models = rootPresenter.present(viewModelScope, screenData)
        )
    }

    /**
     * make into a network Mock layer, will be if we have multiple screens
     */
    private val screenData: List<BaseModel> = listOf(
        GreetingModel(
            title = "Welcome to TasksApp",
            subtitle = "This is the app to help you organize your Tasks to get more stuff done!"
        ),
        TasksModel(
            tasks = mapOf(
                "1" to TaskModel(
                    title = "Task 1",
                    description = "This is the first task",
                    id = "1",
                    status = TaskStatus.COMPLETED
                ),
                "2" to TaskModel(
                    title = "Task 2",
                    description = "This is the second task",
                    id = "2",
                    status = TaskStatus.IN_PROGRESS
                ),
                "3" to TaskModel(
                    title = "Task 3",
                    description = "This is the third task",
                    id = "3",
                    status = TaskStatus.NOT_STARTED
                ),
                "4" to TaskModel(
                    title = "Task 4",
                    description = "This is the fourth task",
                    id = "4",
                    status = TaskStatus.PENDING
                ),
                "5" to TaskModel(
                    title = "Task 5",
                    description = "This is the fifth task",
                    id = "5",
                    status = TaskStatus.COMPLETED
                )
            )
        )
    )
}
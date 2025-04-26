package com.molecule_presenter.api

import androidx.compose.runtime.Composable
import com.data.api.BaseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

/**
 * A reusable Presenter Tree Root that can be referenced by
 * viewModels
 */
interface RootPresenter {

    fun present(scope: CoroutineScope, data: List<BaseModel>): StateFlow<List<BaseModel>>
}
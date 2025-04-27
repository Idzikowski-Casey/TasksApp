package com.application.greeting

import androidx.compose.runtime.Composable
import com.data.api.BaseModel
import com.data.api.models.GreetingModel
import com.molecule_presenter.api.Presenter
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class GreetingPresenter @Inject constructor(): Presenter<GreetingModel>  {

    @Composable
    override fun present(scope: CoroutineScope, model: GreetingModel): BaseModel {
        return model
    }
}
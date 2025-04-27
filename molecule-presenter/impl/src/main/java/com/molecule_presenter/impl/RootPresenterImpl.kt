package com.molecule_presenter.impl

import app.cash.molecule.AndroidUiDispatcher
import app.cash.molecule.RecompositionMode
import app.cash.molecule.launchMolecule
import com.application.di.scope.AppScope
import com.data.api.BaseModel
import com.molecule_presenter.api.Presenter
import com.molecule_presenter.api.PresenterFactory
import com.molecule_presenter.api.RootPresenter
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class RootPresenterImpl @Inject constructor(
    private val presenterFactory: PresenterFactory
) : RootPresenter {

    override fun present(scope: CoroutineScope, data: List<BaseModel>): StateFlow<List<BaseModel>> {
        return scope.launchMolecule(RecompositionMode.ContextClock, context = AndroidUiDispatcher.Main) {
            data.map {
                // if presenter isn't recognized for data model - just return data model
                presenterFactory.createPresenter<Presenter<BaseModel>>(it)?.present(scope, it) ?: it
            }
        }
    }
}
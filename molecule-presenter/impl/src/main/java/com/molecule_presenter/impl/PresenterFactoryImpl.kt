package com.molecule_presenter.impl

import com.application.di.scope.AppScope
import com.molecule_presenter.api.Presenter
import com.molecule_presenter.api.PresenterFactory
import com.molecule_presenter.api.data.BaseModel
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject
import javax.inject.Provider

@ContributesBinding(AppScope::class)
class PresenterFactoryImpl @Inject constructor(
    private val creators: @JvmSuppressWildcards Map<Class<out BaseModel>, Provider<Presenter<out BaseModel>>>
): PresenterFactory {

    override fun <T : Presenter<out BaseModel>> createPresenter(model: BaseModel): T? {
        val presenterProvider = creators[model::class.java] ?: return null

        @Suppress("UNCHECKED_CAST")
        return presenterProvider.get() as? T
    }
}
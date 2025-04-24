package com.molecule_presenter.api

import com.molecule_presenter.api.data.BaseModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * A factory which will Lazily create presenters when needed. Will make it
 * simpler to create presenters within presenters, etc.
 */
interface PresenterFactory {
    fun <T : Presenter<out BaseModel>> createPresenter(model: BaseModel): T?
}

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class PresenterKey(val value: KClass<out BaseModel>)
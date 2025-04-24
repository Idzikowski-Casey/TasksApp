package com.molecule_presenter.api.di

import com.data.api.BaseModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Multibinding map key for getting presenters
 */
@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class PresenterMapKey(val value: KClass<out com.data.api.BaseModel>)
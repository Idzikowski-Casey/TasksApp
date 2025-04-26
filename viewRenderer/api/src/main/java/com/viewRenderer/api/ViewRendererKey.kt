package com.viewRenderer.api

import com.data.api.BaseModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewRendererKey(val value: KClass<out BaseModel>)
package com.viewRenderer.impl

import com.application.di.scope.AppScope
import com.data.api.BaseModel
import com.squareup.anvil.annotations.ContributesBinding
import com.viewRenderer.api.ViewRenderer
import com.viewRenderer.api.ViewRendererFactory
import javax.inject.Inject
import javax.inject.Provider

@ContributesBinding(AppScope::class)
class ViewRendererFactoryImpl @Inject constructor(
    private val creators: @JvmSuppressWildcards Map<Class<out BaseModel>, Provider<ViewRenderer<out BaseModel>>>
): ViewRendererFactory {
    override fun <T : ViewRenderer<out BaseModel>> createViewRenderer(model: BaseModel): T? {
        val viewRendererProvider = creators[model::class.java] ?: return null

        @Suppress("UNCHECKED_CAST")
        return viewRendererProvider.get() as? T
    }
}
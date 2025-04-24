package com.viewRenderer.api

import com.data.api.BaseModel

/**
 * A common factory to be injected and used by consumers who need to create
 * a [ViewRenderer] for a [BaseModel].
 */
interface ViewRendererFactory {
    fun <T: ViewRenderer<out BaseModel>> createViewRenderer(model: BaseModel): T?
}
package com.molecule_presenter.api

import androidx.compose.runtime.Composable
import com.data.api.BaseModel

/**
 * A base interface for all "presenters" within the app. Based on using
 * molecule to turn compose into a StateFlow<BaseModel>.
 *
 * Each Presenter is bound to [BaseModel] of type T. But can produce a different typed
 * [BaseModel] depending upon the business logic.
 */
interface Presenter<T: BaseModel> {

    /**
     * The main fun of the presenter, called by presenter root tree to get
     * display ready data.
     *
     * @param model [BaseModel]
     * @return [BaseModel]
     */
    @Composable
    fun present(model: T): BaseModel
}
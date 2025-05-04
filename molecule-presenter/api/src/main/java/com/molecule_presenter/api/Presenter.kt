package com.molecule_presenter.api

import androidx.compose.runtime.Composable
import com.data.api.BaseModel
import kotlinx.coroutines.CoroutineScope

/**
 * A base interface for all "presenters" within the app. Based on using
 * molecule to turn compose into a StateFlow<BaseModel>.
 *
 * Each Presenter is bound to [BaseModel] of type T. But can produce a different typed
 * [BaseModel] depending upon the business logic.
 */
interface BasePresenter<T : BaseModel> {

    /**
     * The main fun of the presenter, called by presenter root tree to get
     * display ready data.
     *
     * @param model [BaseModel]
     * @param scope [CoroutineScope]
     * @return [BaseModel]
     */
    @Composable
    fun present(scope: CoroutineScope, model: T): BaseModel
}

/**
 * Top level presenter meant to be multibinded to the [BaseModel]
 *
 * Included in the top level factory
 */
interface Presenter<T : BaseModel> : BasePresenter<T>

/**
 * Sub presenter meant to be composed within [Presenter] classes.
 *
 * Not included at the top level factory
 */
interface SubPresenter<T : BaseModel> : BasePresenter<T>
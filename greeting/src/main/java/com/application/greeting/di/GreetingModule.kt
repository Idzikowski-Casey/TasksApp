package com.application.greeting.di

import com.application.di.scope.AppScope
import com.application.greeting.GreetingPresenter
import com.application.greeting.GreetingViewRenderer
import com.data.api.BaseModel
import com.data.api.models.GreetingModel
import com.molecule_presenter.api.Presenter
import com.molecule_presenter.api.PresenterKey
import com.squareup.anvil.annotations.ContributesTo
import com.viewRenderer.api.ViewRenderer
import com.viewRenderer.api.ViewRendererKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
@ContributesTo(AppScope::class)
abstract class GreetingModule {

    @Binds
    @IntoMap
    @PresenterKey(GreetingModel::class)
    abstract fun bindsGreetingPresenter(greetingPresenter: GreetingPresenter): Presenter<out BaseModel>

    @Binds
    @IntoMap
    @ViewRendererKey(GreetingModel::class)
    abstract fun bindsGreetingViewRenderer(greetingViewRenderer: GreetingViewRenderer): ViewRenderer<out BaseModel>
}
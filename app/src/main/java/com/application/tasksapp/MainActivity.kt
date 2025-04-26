package com.application.tasksapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.ux.components.theme.TasksAppTheme
import com.application.greeting.GreetingInfo
import com.application.greeting.GreetingsViewModel
import com.application.tasksscreen.TasksScreenViewModel
import com.data.api.BaseModel
import com.viewRenderer.api.ViewRenderer
import com.viewRenderer.api.ViewRendererFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var viewRendererFactory: ViewRendererFactory

    private val viewModel: TasksScreenViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MainApplication).appComponent.inject(this)

        enableEdgeToEdge()

        setContent {
            TasksAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val state by viewModel.observeScreenState().collectAsState()
                    val models by state.models.collectAsState()

                    Column(modifier = Modifier.padding(innerPadding)) {
                        models.forEach {
                            val renderer = viewRendererFactory.createViewRenderer<ViewRenderer<BaseModel>>(it)
                            renderer?.Render(it, Modifier)
                        }
                    }
                }
            }
        }
    }
}
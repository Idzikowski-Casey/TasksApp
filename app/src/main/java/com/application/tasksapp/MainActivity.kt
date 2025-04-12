package com.application.tasksapp

import android.os.Bundle
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.ux.components.theme.TasksAppTheme
import com.application.greeting.GreetingInfo
import com.application.greeting.GreetingsViewModel
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: GreetingsViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MainApplication).appComponent.inject(this)

        enableEdgeToEdge()

        setContent {
            TasksAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val state = viewModel.getGreetings().collectAsState()

                    Column(modifier = Modifier.padding(16.dp)) {
                        Greeting(
                            greetingInfo = state.value,
                            modifier = Modifier.padding(innerPadding)
                        )
                        Button(onClick = { viewModel.onClick() }) {
                            Text(text = "Click Me")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(greetingInfo: GreetingInfo, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Name : ${greetingInfo.name}",
            modifier = modifier
        )
        Text(
            text = "Greeting : ${greetingInfo.greeting}",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TasksAppTheme {
        Greeting(GreetingInfo("Android", "Hello from Android"))
    }
}
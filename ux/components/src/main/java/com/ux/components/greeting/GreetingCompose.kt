package com.ux.components.greeting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.data.api.models.GreetingModel
import com.ux.components.dimensions.TaskDimensions
import com.ux.components.theme.TasksAppTheme

@Composable
fun GreetingCompose(model: GreetingModel, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(TaskDimensions.s4.value),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(model.title, style = MaterialTheme.typography.headlineSmall)
        Text(model.subtitle, style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview
@Composable
fun GreetingPreview() {
    val title = "Welcome to Tasks App"
    val subtitle = "This is a sample subtitle"
    TasksAppTheme {
        GreetingCompose(GreetingModel(title, subtitle))
    }
}
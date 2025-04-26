package com.ux.components.tasks

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ux.components.dimensions.TaskDimensions
import com.ux.components.theme.TasksAppTheme

@Composable
fun TasksDeleteCompose(onDelete: () -> Unit, modifier: Modifier = Modifier) {
    IconButton (onClick = onDelete, modifier = modifier.size(TaskDimensions.s4.value)) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Delete"
        )
    }
}


@Preview
@Composable
fun TasksDeleteComposePreview() {
    TasksAppTheme {
        TasksDeleteCompose(onDelete = {})
    }
}
package com.ux.components.tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ux.components.dimensions.TaskDimensions
import com.ux.components.theme.TasksAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksDeleteCompose(taskTitle: String, onDelete: () -> Unit, modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(false) }

    IconButton(onClick = { showDialog = true }, modifier = modifier) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Delete"
        )
    }
    if (showDialog) {
        BasicAlertDialog(onDismissRequest = { showDialog = false }) {
            DeleteDialogContent(
                title = taskTitle,
                onDelete = {
                    onDelete()
                    showDialog = false
                },
                onCancel = { showDialog = false })
        }
    }
}

@Composable
fun DeleteDialogContent(title: String, onDelete: () -> Unit, onCancel: () -> Unit) {
    Card(
        modifier = Modifier.padding(TaskDimensions.s4.value),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        )
    ) {
        Column(Modifier.padding(TaskDimensions.s4.value), verticalArrangement = Arrangement.spacedBy(TaskDimensions.s2.value)) {
            Text("Delete: $title", style = MaterialTheme.typography.titleLarge)
            Text(
                "Are you sure you want to delete this task?",
                style = MaterialTheme.typography.bodyMedium
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(onClick = onDelete) {
                    Text("Delete")
                }
                OutlinedButton (onClick = onCancel) {
                    Text("Cancel")
                }
            }
        }
    }
}


@Preview
@Composable
fun TasksDeleteComposePreview() {
    TasksAppTheme {
        TasksDeleteCompose(taskTitle = "Task Title", onDelete = {})
    }
}

@Preview
@Composable
fun DeleteDialogContentPreview() {
    TasksAppTheme {
        Column(Modifier.widthIn(max = TaskDimensions.s300.value)) {
            DeleteDialogContent(title = "Task Title", onDelete = {}, onCancel = {})
        }
    }
}


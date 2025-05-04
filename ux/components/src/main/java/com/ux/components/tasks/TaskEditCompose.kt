package com.ux.components.tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ux.components.dimensions.TaskDimensions
import com.ux.components.theme.TasksAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskEditCompose(
    taskTitle: String,
    taskDescription: String,
    modifier: Modifier = Modifier,
    onSave: (title: String, description: String) -> Unit = { _, _ -> },
    isEditDialogShown: Boolean = false,
    onEditDismiss: () -> Unit = {},
    onEdit: () -> Unit = {}
) {
    IconButton(onClick = onEdit, modifier = modifier) {
        Icon(
            imageVector = Icons.Filled.Edit,
            contentDescription = "Edit"
        )
    }
    if (isEditDialogShown) {
        BasicAlertDialog(onDismissRequest = onEditDismiss) {
            EditDialogContent(
                title = taskTitle,
                description = taskDescription,
                onSave = onSave,
                onCancel = onEditDismiss,
            )
        }
    }
}

@Composable
fun EditDialogContent(
    title: String,
    description: String,
    onSave: (title: String, description: String) -> Unit,
    onCancel: () -> Unit,
) {
    var _title by rememberSaveable { mutableStateOf(title) }
    var _description by rememberSaveable { mutableStateOf(description) }

    Card(
        modifier = Modifier.padding(TaskDimensions.s4.value),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        )
    ) {
        Column(
            Modifier.padding(TaskDimensions.s4.value),
            verticalArrangement = Arrangement.spacedBy(TaskDimensions.s2.value)
        ) {

            OutlinedTextField(
                _title, onValueChange = { _title = it }, Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                textStyle = MaterialTheme.typography.titleLarge,
                label = {
                    Text("Title")
                }

            )
            OutlinedTextField(
                _description, onValueChange = { _description = it }, modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(10.dp),
                singleLine = false,
                label = {
                    Text("Description")
                }
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(onClick = {
                    onSave(_title, _description)
                }) {
                    Text("Save")
                }
                OutlinedButton(onClick = onCancel) {
                    Text("Cancel")
                }
            }
        }
    }
}

@Composable
@Preview
fun TaskEditComposePreview() {
    TasksAppTheme {
        TaskEditCompose(
            taskTitle = "Task Title",
            taskDescription = "Task Description"
        )
    }
}

@Composable
@Preview
fun TaskEditDialogComposePreview() {
    TasksAppTheme {
        EditDialogContent(
            title = "Task Title",
            description = "Task Description",
            onSave = { _, _ -> },
            onCancel = {}
        )
    }
}
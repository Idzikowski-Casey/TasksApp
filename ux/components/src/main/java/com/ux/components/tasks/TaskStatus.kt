package com.ux.components.tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.data.api.models.TaskStatus
import com.ux.components.dimensions.TaskDimensions

@Composable
fun TaskStatus(
    modifier: Modifier = Modifier,
    status: TaskStatus,
    onStatusSelect: (TaskStatus) -> Unit = {}
) {
    var isMenuExpanded by remember { mutableStateOf(false) }

    val buttonColors = IconButtonColors(
        containerColor = TaskColors.getContainerColorForStatus(status),
        contentColor = TaskColors.getContentColorForStatus(status),
        disabledContainerColor = TaskColors.getContainerColorForStatus(status),
        disabledContentColor = TaskColors.getContentColorForStatus(status),
    )
    FilledTonalIconButton(
        modifier = modifier,
        colors = buttonColors,
        onClick = { isMenuExpanded = true }
    ) {
        Icon(
            imageVector = TaskStatusIcons.getIcon(status),
            contentDescription = status.value
        )
    }
    TaskStatusPicker(
        expanded = isMenuExpanded,
        onDismiss = { isMenuExpanded = false },
        onSelect = { selectedStatus ->
            isMenuExpanded = false
            onStatusSelect(selectedStatus)
        })
}

@Composable
fun TaskStatusPicker(
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    onDismiss: () -> Unit = {},
    onSelect: (TaskStatus) -> Unit = {}
) {
    DropdownMenu(
        expanded,
        onDismiss,
        modifier.padding(TaskDimensions.s1.value),
        containerColor = MaterialTheme.colorScheme.surface,
    ) {
        TaskStatus.entries.forEach { status ->
            val buttonColors = ButtonColors(
                containerColor = TaskColors.getContainerColorForStatus(status),
                contentColor = TaskColors.getContentColorForStatus(status),
                disabledContainerColor = TaskColors.getContainerColorForStatus(status),
                disabledContentColor = TaskColors.getContentColorForStatus(status),
            )

            FilledTonalButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onSelect(status) },
                colors = buttonColors,
                contentPadding = PaddingValues(horizontal = TaskDimensions.s2.value)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        imageVector = TaskStatusIcons.getIcon(status),
                        contentDescription = status.value
                    )
                    Text(
                        status.value,
                        modifier = Modifier.padding(start = TaskDimensions.s2.value)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun TaskStatusPreview() {
    TaskStatus(status = TaskStatus.COMPLETED)
}

@Composable
@Preview
fun TaskStatusPickerPreview() {
    TaskStatusPicker(expanded = true)
}
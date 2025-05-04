package com.ux.components.tasks

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.TrendingUp
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.DoNotDisturbOn
import androidx.compose.material.icons.outlined.Update
import androidx.compose.ui.graphics.vector.ImageVector
import com.data.api.models.TaskStatus

object TaskStatusIcons {
    private val completed = Icons.Outlined.CheckCircle
    private val notStarted = Icons.Outlined.DoNotDisturbOn
    private val inProgress = Icons.AutoMirrored.Outlined.TrendingUp
    private val pending = Icons.Outlined.Update

    fun getIcon(status: TaskStatus): ImageVector {
        return when (status) {
            TaskStatus.COMPLETED -> completed
            TaskStatus.NOT_STARTED -> notStarted
            TaskStatus.IN_PROGRESS -> inProgress
            TaskStatus.PENDING -> pending
        }
    }
}
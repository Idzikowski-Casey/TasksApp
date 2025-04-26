package com.ux.components.tasks

import androidx.compose.ui.graphics.Color
import com.data.api.models.TaskStatus

object TaskColors {
    // container colors
    private val Red60 = Color(0x99F44336)
    private val Green60 = Color(0x994CAF50)
    private val Blue60 = Color(0x992196F3)
    private val Yellow60 = Color(0x99FFEB3B)

    // content colors
    private val ContentRed = Color(0xFF6C1D17)
    private val ContentGreen = Color(0xFF265729)
    private val ContentBlue = Color(0x99072333)
    private val ContentYellow = Color(0x995B5416)

    fun getContainerColorForStatus(status: TaskStatus): Color {
        return when (status) {
            TaskStatus.NEW -> Red60
            TaskStatus.IN_PROGRESS -> Blue60
            TaskStatus.PENDING -> Yellow60
            TaskStatus.COMPLETED -> Green60
        }
    }

    fun getContentColorForStatus(status: TaskStatus): Color {
        return when (status) {
            TaskStatus.NEW -> ContentRed
            TaskStatus.IN_PROGRESS -> ContentBlue
            TaskStatus.PENDING -> ContentYellow
            TaskStatus.COMPLETED -> ContentGreen
        }
    }
}
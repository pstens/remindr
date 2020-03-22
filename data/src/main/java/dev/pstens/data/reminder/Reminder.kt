package dev.pstens.data.reminder

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "reminders")
data class Reminder(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val date: Long
)

data class ReminderWithTasks(
    @Embedded val reminder: Reminder,
    @Relation(parentColumn = "id", entityColumn = "reminderId", entity = Task::class)
    val tasks: List<Task>
)
package dev.pstens.cache

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "tasks", indices = [Index("reminderId")])
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val priority: Int,
    val title: String,
    val reminderId: Int
)

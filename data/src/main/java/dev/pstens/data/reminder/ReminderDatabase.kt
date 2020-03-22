package dev.pstens.data.reminder

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Reminder::class, Task::class], version = 1)
abstract class ReminderDatabase(): RoomDatabase() {
    abstract fun reminderDao(): ReminderDao

    companion object {
        fun instantiate(context: Context) = Room
            .databaseBuilder(context, ReminderDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
    }
}
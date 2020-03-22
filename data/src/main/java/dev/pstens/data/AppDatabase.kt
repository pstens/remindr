package dev.pstens.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.pstens.data.reminder.Reminder
import dev.pstens.data.reminder.ReminderDao
import dev.pstens.data.reminder.Task
import dev.pstens.data.user.User
import dev.pstens.data.user.UserDao

@Database(entities = [Reminder::class, Task::class, User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun reminderDao(): ReminderDao
    abstract fun userDao(): UserDao

    companion object {
        fun instantiate(context: Context) = Room
            .databaseBuilder(context, AppDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
    }
}
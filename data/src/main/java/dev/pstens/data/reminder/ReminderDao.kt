package dev.pstens.data.reminder

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.pstens.data.reminder.Reminder
import kotlinx.coroutines.flow.Flow


@Dao
interface ReminderDao {
    @Query("SELECT * FROM reminders")
    fun fetchAll(): Reminder?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg stats: Reminder)
}
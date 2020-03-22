package dev.pstens.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface ReminderDao {
    @Query("SELECT * FROM reminders")
    fun fetchAll(): Flow<Reminder>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg stats: Reminder)
}
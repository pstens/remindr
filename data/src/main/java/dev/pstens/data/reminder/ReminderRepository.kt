package dev.pstens.data.reminder

import dev.pstens.domain.reminder.Reminder
import dev.pstens.domain.reminder.ReminderRepository

class ReminderRepositoryImpl(
    private val localDataSource: LocalReminderSource,
    private val remoteDataSource: RemoteReminderSource
): ReminderRepository {

    override suspend fun getReminderForToday(): Reminder? {
        TODO("not implemented")
    }

    override suspend fun saveReminder(reminder: Reminder) {
        TODO("not implemented")
    }

    override suspend fun clearReminders() {
        TODO("not implemented")
    }
}

interface LocalReminderSource {
    suspend fun getForToday(): Reminder?
    suspend fun add(reminder: Reminder)
}

interface RemoteReminderSource {
    suspend fun fetchForToday(): Reminder?
}
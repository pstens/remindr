package dev.pstens.domain

interface ReminderRepository {

    suspend fun getReminderForToday(): Reminder?

    suspend fun saveReminder(reminder: Reminder)

    suspend fun clearReminders()
}
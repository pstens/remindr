package dev.pstens.domain.reminder

import dev.pstens.domain.reminder.Reminder

interface ReminderRepository {

    suspend fun getReminderForToday(): Reminder?

    suspend fun saveReminder(reminder: Reminder)

    suspend fun clearReminders()
}
package dev.pstens.data.reminder

import dev.pstens.data.reminder.LocalReminderSource
import dev.pstens.domain.reminder.Reminder

class InMemoryDataSource : LocalReminderSource {
    private var cachedReminder: Reminder? = null

    override suspend fun getForToday(): Reminder? = cachedReminder

    override suspend fun add(reminder: Reminder) {
        cachedReminder = reminder
    }
}
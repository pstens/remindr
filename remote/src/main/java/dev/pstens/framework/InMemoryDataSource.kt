package dev.pstens.framework

import dev.pstens.data.LocalReminderSource
import dev.pstens.domain.Reminder

class InMemoryDataSource : LocalReminderSource {
    private var cachedReminder: Reminder? = null

    override suspend fun getForToday(): Reminder? = cachedReminder

    override suspend fun add(reminder: Reminder) {
        cachedReminder = reminder
    }
}
package dev.pstens.domain.reminder

import dev.pstens.domain.reminder.Reminder

class GetReminder(private val repo: ReminderRepository) {
    suspend operator fun invoke(): Reminder? = repo.getReminderForToday()
}
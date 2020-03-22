package dev.pstens.usecases

import dev.pstens.data.ReminderRepository
import dev.pstens.domain.Reminder

class GetReminder(private val repo: ReminderRepository) {
    suspend operator fun invoke(): Reminder? = repo.getReminderForToday()
}
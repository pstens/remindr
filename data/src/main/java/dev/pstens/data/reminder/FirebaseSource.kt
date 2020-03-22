package dev.pstens.data.reminder

import dev.pstens.data.reminder.RemoteReminderSource
import dev.pstens.domain.reminder.Reminder

class FirebaseSource : RemoteReminderSource {

    override suspend fun fetchForToday(): Reminder? {
        TODO("not implemented")
    }
}
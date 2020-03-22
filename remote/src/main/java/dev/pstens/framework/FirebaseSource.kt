package dev.pstens.framework

import dev.pstens.data.RemoteReminderSource
import dev.pstens.domain.Reminder

class FirebaseSource : RemoteReminderSource {

    override suspend fun fetchForToday(): Reminder? {
        TODO("not implemented")
    }
}
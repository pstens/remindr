package dev.pstens.data.user

import dev.pstens.data.AppDatabase
import dev.pstens.domain.user.User


class RoomStorage(private val dao: UserDao) : LocalUserStore {

    override suspend fun saveUser(user: User?) {}

    override suspend fun getCurrentUser(): User? {
        return null
    }

    override suspend fun logout(): Boolean {
        return true
    }
}
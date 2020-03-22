package dev.pstens.data.user

import dev.pstens.domain.user.User
import dev.pstens.domain.user.UserRepository

class UserRepositoryImpl(
    private val localStorage: LocalUserStore,
    private val remoteStorage: RemoteUserStore
) : UserRepository {
    override suspend fun login(email: String, password: String): User? {
        val cachedUser = getCurrentUser()
        return if (cachedUser == null) {
            val remoteUser = remoteStorage.register(email, password)
            localStorage.saveUser(remoteUser)
            remoteUser
        } else {
            cachedUser
        }
    }

    override suspend fun logout(): Boolean = localStorage.logout()

    override suspend fun getCurrentUser(): User? = localStorage.getCurrentUser()
}

interface LocalUserStore {
    suspend fun saveUser(user: User?)
    suspend fun getCurrentUser(): User?
    suspend fun logout(): Boolean
}

interface RemoteUserStore {
    suspend fun register(email: String, password: String): User?
}

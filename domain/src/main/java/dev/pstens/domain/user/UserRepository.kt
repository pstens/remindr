package dev.pstens.domain.user

interface UserRepository {
    suspend fun login(email: String, password: String): User?
    suspend fun logout(): Boolean
    suspend fun getCurrentUser(): User?
}
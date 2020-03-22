package dev.pstens.domain.reminder

import dev.pstens.domain.user.UserRepository

class LoginWithEmail(private val repo: UserRepository) {
    suspend operator fun invoke(email: String, password: String) = repo.login(email, password)
}
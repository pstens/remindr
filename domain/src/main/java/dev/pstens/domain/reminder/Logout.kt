package dev.pstens.domain.reminder

import dev.pstens.domain.user.UserRepository

class Logout(private val repo: UserRepository) {
    suspend operator fun invoke() = repo.logout()
}
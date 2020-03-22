package dev.pstens.domain.user

class GetCurrentUser(private val repo: UserRepository) {
    suspend operator fun invoke(): User? = repo.getCurrentUser()
}

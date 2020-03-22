package dev.pstens.remindr

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.pstens.domain.reminder.LoginWithEmail
import kotlinx.coroutines.launch

class UserViewModel(private val loginWithEmail: LoginWithEmail) : ViewModel() {

    fun login(email: String, password: String) = viewModelScope.launch {
        val user = loginWithEmail(email, password)
        print("$user")
    }
}
package dev.pstens.data.user

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import dev.pstens.domain.user.User
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class FirebaseStorage(private val auth: FirebaseAuth) : RemoteUserStore {
    override suspend fun register(email: String, password: String): User? {
        val authResult = createUser(email, password)
        return if (authResult == null) {
            null
        } else {
            User("numero uno", "zwei", "drei")
        }
    }

    private suspend fun createUser(email: String, password: String) =
        suspendCancellableCoroutine<AuthResult?> { cont ->
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        cont.resume(task.result)
                    } else {
                        cont.resume(null)
                    }
                }
        }
}

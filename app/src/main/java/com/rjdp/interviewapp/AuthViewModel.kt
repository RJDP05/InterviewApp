package com.rjdp.interviewapp

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel : ViewModel(){
    private val auth : FirebaseAuth = FirebaseAuth.getInstance()
    private val _authState = MutableStateFlow<AuthState>(AuthState.Loading)
    val authState : StateFlow<AuthState> = _authState.asStateFlow()

    private val authStateListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
        val user = firebaseAuth.currentUser
        val newState = if (user != null) AuthState.Authenticated else AuthState.Unauthenticated

        // Only dispatch if the state actually changes
        if (_authState.value != newState) {
            _authState.value = newState
        }
    }

    init {
        auth.addAuthStateListener(authStateListener)
    }

    override fun onCleared() {
        super.onCleared()
        auth.removeAuthStateListener(authStateListener)
    }


    fun logIn(email: String, password: String) {

        if (email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Error("Email and Password cannot be empty")
            return
        }

        _authState.value = AuthState.Loading
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    _authState.value = AuthState.Error(task.exception?.localizedMessage ?: "Login failed")
                }
            }
    }

    fun signUp(email: String, password: String) {

        if (email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Error("Email and Password cannot be empty")
            return
        }

        _authState.value = AuthState.Loading
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    _authState.value = AuthState.Error(task.exception?.localizedMessage ?: "Registration failed")
                }
            }
    }

    fun signOut() {
        auth.signOut()
    }

    fun sendPasswordReset(email: String) {

        if (email.isEmpty()) {
            _authState.value = AuthState.Error("Email cannot be empty")
            return
        }
        _authState.value = AuthState.Loading
        auth.sendPasswordResetEmail(email)
            .addOnSuccessListener {
                _authState.value = AuthState.Unauthenticated
            }
            .addOnFailureListener { ex ->
                _authState.value = AuthState.Error(ex.localizedMessage ?: "Reset email failed")
            }
    }

    fun setError(message: String) {
        _authState.value = AuthState.Error(message)
    }

}

sealed class AuthState {
    object Unauthenticated : AuthState()
    object Authenticated : AuthState()
    object Loading : AuthState()
    data class Error(val message: String) : AuthState()
}
package com.rjdp.interviewapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyViewModel: ViewModel(){
    private val _isAuthenticated = MutableStateFlow(false)
    val isAuthenticated: StateFlow<Boolean> = _isAuthenticated

    fun loginSuccess() {
        _isAuthenticated.value = true
    }

    fun logout() {
        _isAuthenticated.value = false
    }
}
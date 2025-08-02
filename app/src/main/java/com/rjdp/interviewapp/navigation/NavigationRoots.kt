package com.rjdp.interviewapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assistant
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Assistant
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.rjdp.interviewapp.R


// 1. Navigation Routes and Destinations
object Routes {
    // Root level routes
    const val AUTH_ROOT = "auth_root"
    const val MAIN_ROOT = "main_root"

    // Auth flow routes
    const val WELCOME = "welcome"
    const val LOGIN = "login"
    const val SIGNUP = "signup"
    const val FORGOT_PASSWORD = "forgot_password"

    // Main flow routes
    const val HOME = "home"
    const val INTERVIEW = "interview"
    const val SETTINGS = "settings"
}


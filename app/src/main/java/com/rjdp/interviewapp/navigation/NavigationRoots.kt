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


sealed class Screen(val route: String) {

    // Root graph identifiers
    object AuthGraph : Screen("auth_graph")
    object MainGraph : Screen("main_graph")

    // Auth flow screens
    object Welcome : Screen("auth/welcome")
    object Login : Screen("auth/login")
    object SignUp : Screen("auth/signup")
    object ForgotPassword : Screen("auth/forgot_password")

    // Main flow screens
    object Home : Screen("main/home")
    object Interview : Screen("main/interview")
    object Settings : Screen("main/settings")
}



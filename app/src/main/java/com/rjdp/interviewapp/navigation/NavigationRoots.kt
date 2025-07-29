package com.rjdp.interviewapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assistant
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Assistant
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable


@Serializable
sealed class Screen {

    @Serializable
    object AuthRoot : Screen()

    @Serializable
    sealed class Auth : Screen() {

        @Serializable
        object Welcome : Auth()

        @Serializable
        object SignUp : Auth()

        @Serializable
        object LogIn : Auth()

        @Serializable
        object ForgotPassword : Auth()
    }

    @Serializable
    object HomeRoot : Screen()

    @Serializable
    sealed class Home : Screen() {

        @Serializable
        object Main : Home()

        @Serializable
        object Interview : Home()

        @Serializable
        object Settings : Home()
    }
}

@Serializable
sealed class BottomNavigationItems<T>(
    val name: String,
    val route: T,
    @Contextual
    val unSelectedIcon: ImageVector,
    @Contextual
    val selectedIcon: ImageVector // filled icon when selected
     // unfilled icon when not selected
) {

    data object Home : BottomNavigationItems<Screen.Home>(
        name = "Home",
        route = Screen.Home.Main,
        unSelectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home,
    )

    data object Interview : BottomNavigationItems<Screen.Home>(
        name = "Interview",
        route = Screen.Home.Interview,
        unSelectedIcon = Icons.Outlined.Assistant,
        selectedIcon = Icons.Filled.Assistant,
    )

    data object Settings : BottomNavigationItems<Screen.Home>(
        name = "Settings",
        route = Screen.Home.Settings,
        unSelectedIcon = Icons.Outlined.Settings,
        selectedIcon = Icons.Filled.Settings,
    )

}

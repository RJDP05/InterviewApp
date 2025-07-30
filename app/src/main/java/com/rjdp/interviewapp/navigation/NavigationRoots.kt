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
    // Auth Flow
    object Welcome : Screen("welcome")
    object Login : Screen("login")
    object SignUp : Screen("signup")
    object ForgotPassword : Screen("forgot_password")

    // Main Flow
    object Main : Screen("main")
}

//@Serializable
//sealed class Screen {
//
//    @Serializable
//    object AuthRoot : Screen()
//
//    @Serializable
//    sealed class Auth : Screen() {
//
//        @Serializable
//        object Welcome : Auth()
//
//        @Serializable
//        object SignUp : Auth()
//
//        @Serializable
//        object LogIn : Auth()
//
//        @Serializable
//        object ForgotPassword : Auth()
//    }
//
//    @Serializable
//    object HomeRoot : Screen()
//
//    @Serializable
//    sealed class Home : Screen() {
//
//        @Serializable
//        object Main : Home()
//
//        @Serializable
//        object Interview : Home()
//
//        @Serializable
//        object Settings : Home()
//    }
//}

//sealed class TopLevelDestination(
//    val route: String,
//    val titleRes: Int? = null,
//    val selectedIcon: ImageVector? = null,
//    val unSelectedIcon: ImageVector? = null,
//    //val navArguments: List<NamedNavArgument> = emptyList()
//)
//
//
////String Based Navigation Routes
//private object Routes {
//
//    // Authentication Navigation
//    const val AUTH = "auth"
//    const val WELCOME = "welcome"
//    const val LOGIN = "login"
//    const val REGISTER = "signup"
//    const val FORGET_PASSWORD = "forgot_password"
//
//    // Main Navigation
//    const val MAIN = "main"
//    const val HOME = "home"
//    const val INTERVIEW = "interview"
//    const val SETTINGS = "settings"
//}
//
//sealed class AppScreen(val route: String) {
//
//    object AuthNav : AppScreen(Routes.AUTH) {
//        object Login : AppScreen(Routes.LOGIN)
//        object Register : AppScreen(Routes.REGISTER)
//        object ForgotPassword : AppScreen(Routes.FORGET_PASSWORD)
//        object Welcome : AppScreen(Routes.WELCOME)
//    }
//
//    object MainNav : TopLevelDestination(Routes.MAIN) {
//
//        object Home : TopLevelDestination(
//            route = Routes.HOME,
//            titleRes = R.string.home,
//            selectedIcon = Icons.Filled.Home,
//            unSelectedIcon = Icons.Outlined.Home
//        )
//
//        object Interview : TopLevelDestination(
//            route = Routes.INTERVIEW,
//            titleRes = R.string.interview,
//            selectedIcon = Icons.Filled.Assistant,
//            unSelectedIcon = Icons.Outlined.Assistant
//        )
//
//        object Settings : TopLevelDestination(
//            route = Routes.SETTINGS,
//            titleRes = R.string.settings,
//            selectedIcon = Icons.Filled.Settings,
//            unSelectedIcon = Icons.Outlined.Settings
//        )
//    }
//}



//@Serializable
//sealed class BottomNavigationItems<T>(
//    val name: String,
//    val route: T,
//    @Contextual
//    val unSelectedIcon: ImageVector,
//    @Contextual
//    val selectedIcon: ImageVector // filled icon when selected
//     // unfilled icon when not selected
//) {
//
//    data object Home : BottomNavigationItems<Screen.Home>(
//        name = "Home",
//        route = Screen.Home.Main,
//        unSelectedIcon = Icons.Outlined.Home,
//        selectedIcon = Icons.Filled.Home,
//    )
//
//    data object Interview : BottomNavigationItems<Screen.Home>(
//        name = "Interview",
//        route = Screen.Home.Interview,
//        unSelectedIcon = Icons.Outlined.Assistant,
//        selectedIcon = Icons.Filled.Assistant,
//    )
//
//    data object Settings : BottomNavigationItems<Screen.Home>(
//        name = "Settings",
//        route = Screen.Home.Settings,
//        unSelectedIcon = Icons.Outlined.Settings,
//        selectedIcon = Icons.Filled.Settings,
//    )
//
//}


//sealed class BottomNavigationItem(
//    val name: String,
//    val route: String,
//    val unSelectedIcon: ImageVector? = null,
//    val selectedIcon: ImageVector? = null
//) {
//    object Home : BottomNavigationItem(
//        name = "Home",
//        route = Screen.Home.Main.route,
//        unSelectedIcon = Icons.Outlined.Home,
//        selectedIcon = Icons.Filled.Home
//    )
//    object Interview : BottomNavigationItem(
//        name = "Interview",
//        route = Screen.Home.Interview.route,
//        unSelectedIcon = Icons.Outlined.Assistant,
//        selectedIcon = Icons.Filled.Assistant
//    )
//    object Settings : BottomNavigationItem(
//        name = "Settings",
//        route = Screen.Home.Settings.route,
//        unSelectedIcon = Icons.Outlined.Settings,
//        selectedIcon = Icons.Filled.Settings
//    )
//}


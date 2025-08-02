package com.rjdp.interviewapp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rjdp.interviewapp.AuthViewModel
import com.rjdp.interviewapp.ui.screens.main.HomeScreen
import com.rjdp.interviewapp.ui.screens.main.InterviewScreen
import com.rjdp.interviewapp.ui.screens.main.MainScreenWithBottomNav
import com.rjdp.interviewapp.ui.screens.main.SettingsScreen

fun NavGraphBuilder.mainNavGraph(
    navController: NavController,
    authViewModel: AuthViewModel
) {
    navigation(
        startDestination = Routes.HOME,
        route = Routes.MAIN_ROOT
    ) {
        composable(Routes.HOME) {
            MainScreenWithBottomNav(
                currentRoute = Routes.HOME,
                onNavigate = { route ->
                    navController.navigate(route) {
                        popUpTo(Routes.HOME) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                onSignOut = { authViewModel.signOut() }
            ) {
                HomeScreen()
            }
        }

        composable(Routes.INTERVIEW) {
            MainScreenWithBottomNav(
                currentRoute = Routes.INTERVIEW,
                onNavigate = { route ->
                    navController.navigate(route) {
                        popUpTo(Routes.HOME) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                onSignOut = { authViewModel.signOut() }
            ) {
                InterviewScreen()
            }
        }

        composable(Routes.SETTINGS) {
            MainScreenWithBottomNav(
                currentRoute = Routes.SETTINGS,
                onNavigate = { route ->
                    navController.navigate(route) {
                        popUpTo(Routes.HOME) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                onSignOut = { authViewModel.signOut() }
            ) {
                SettingsScreen(onSignOut = { authViewModel.signOut() })
            }
        }
    }
}

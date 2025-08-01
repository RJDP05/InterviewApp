package com.rjdp.interviewapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rjdp.interviewapp.ui.screens.main.HomeScreen
import com.rjdp.interviewapp.ui.screens.main.InterviewScreen
import com.rjdp.interviewapp.ui.screens.main.SettingsScreen

fun NavGraphBuilder.mainNavGraph(navController: NavHostController) {
    navigation(startDestination = Screen.Home.route, route = Screen.MainGraph.route) {
        composable(Screen.Home.route) {
            HomeScreen(
                onSignOut = {
            navController.navigate(Screen.Welcome.route) {
                popUpTo(Screen.MainGraph.route) { inclusive = true }
                }
            })
        }
        composable(Screen.Interview.route) { InterviewScreen() }
        composable(Screen.Settings.route) { SettingsScreen() }
    }
}

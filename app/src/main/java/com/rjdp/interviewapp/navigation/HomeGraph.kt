package com.rjdp.interviewapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation


fun NavGraphBuilder.homeGraph(navController: NavHostController) {

    navigation<Screen.HomeRoot>(
        startDestination = Screen.Home.Main
    ) {
        composable<Screen.Home.Main> {
            HomeNavHost()
        }

        composable<Screen.Home.Interview> {
            InterviewNavHost()
        }

        composable<Screen.Home.Settings> {
            SettingsNavHost()
        }
    }
}
package com.rjdp.interviewapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rjdp.interviewapp.HomeScaffold
import com.rjdp.interviewapp.navigation.BottomNavigationItems.Home.route
import com.rjdp.interviewapp.ui.screens.main.InterviewScreen
import com.rjdp.interviewapp.ui.screens.main.SettingsScreen

@Composable
fun HomeNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.Main){

        composable<Screen.Home.Main> {
            HomeScaffold(navController)
        }

    }

}

@Composable
fun InterviewNavHost() {
    val ctrl = rememberNavController()
    NavHost(ctrl, startDestination = Screen.Home.Interview) {
        composable<Screen.Home.Interview> { InterviewScreen() }
    }
}

@Composable
fun SettingsNavHost() {
    val ctrl = rememberNavController()
    NavHost(ctrl, startDestination = Screen.Home.Settings) {
        composable<Screen.Home.Settings> { SettingsScreen() }
    }
}

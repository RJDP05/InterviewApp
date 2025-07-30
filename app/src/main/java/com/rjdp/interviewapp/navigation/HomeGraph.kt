//package com.rjdp.interviewapp.navigation
//
//import androidx.navigation.NavGraphBuilder
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.composable
//import androidx.navigation.navigation
//import com.rjdp.interviewapp.ui.screens.main.HomeScreen
//import com.rjdp.interviewapp.ui.screens.main.InterviewScreen
//import com.rjdp.interviewapp.ui.screens.main.SettingsScreen
//
//
//fun NavGraphBuilder.homeGraph(navController: NavHostController) {
//
//    navigation(
//        startDestination = AppScreen.MainNav.Home.route,
//        route = AppScreen.MainNav.route
//    ) {
//        composable(AppScreen.MainNav.Home.route) {
//            HomeScreen(onLogout = {
//                navController.navigate(AppScreen.AuthNav.route) {
//                    popUpTo(AppScreen.MainNav.route) { inclusive = true }
//                }
//            })
//        }
//        composable(AppScreen.MainNav.Interview.route) {
//            InterviewScreen()
//        }
//        composable(AppScreen.MainNav.Settings.route) {
//            SettingsScreen()
//        }
//    }
//}
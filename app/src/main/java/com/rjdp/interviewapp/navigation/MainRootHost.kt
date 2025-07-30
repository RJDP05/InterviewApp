package com.rjdp.interviewapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rjdp.interviewapp.ui.screens.auth.LogInScreen
import com.rjdp.interviewapp.ui.screens.auth.SignUpScreen
import com.rjdp.interviewapp.ui.screens.auth.WelcomeScreen
import com.rjdp.interviewapp.ui.screens.main.MainScreen


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        // Auth Flow
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onLogInClick = {
                    navController.navigate(Screen.Login.route)
                },
                onSignUpClick = {
                    navController.navigate(Screen.SignUp.route)
                }
            )
        }

        composable(Screen.Login.route) {
            LogInScreen(
                onForgotPassword = { navController.navigate(Screen.ForgotPassword.route)},
                onLogInSuccess = {
                    // Navigate to Main and clear back stack
                    navController.navigate(Screen.Main.route) {
                        popUpTo(Screen.Welcome.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.SignUp.route) {
            SignUpScreen(
                onSignUpSuccess = {
                    // Navigate to Main and clear back stack
                    navController.navigate(Screen.Main.route) {
                        popUpTo(Screen.Welcome.route) { inclusive = true }
                    }
                }
            )
        }

//        composable(Screen.ForgotPassword.route) {
//            ForgotPasswordScreen(
//                onNavigateBack = {
//                    navController.popBackStack()
//                }
//            )
//        }

        // Main Flow
        composable(Screen.Main.route) {
            MainScreen()
        }
    }
}
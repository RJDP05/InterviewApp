package com.rjdp.interviewapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rjdp.interviewapp.ui.screens.auth.LogInScreen
import com.rjdp.interviewapp.ui.screens.auth.SignUpScreen
import com.rjdp.interviewapp.ui.screens.auth.WelcomeScreen


fun NavGraphBuilder.authGraph(navController: NavHostController) {

    navigation<Screen.AuthRoot>(
        startDestination = Screen.Auth.Welcome
    ) {
        composable<Screen.Auth.Welcome> {
            // Welcome Screen
            WelcomeScreen(
                onSignUpClick = { navController.navigate(Screen.Auth.SignUp) },
                onLogInClick = { navController.navigate(Screen.Auth.LogIn) }
            )
        }

        composable<Screen.Auth.SignUp> {
            // Sign Up Screen
            SignUpScreen(
                onSignUpSuccess = {
                    navController.navigate(Screen.HomeRoot) {
                        popUpTo(Screen.AuthRoot) { inclusive = true }
                    }
                }
            )
        }

        composable<Screen.Auth.LogIn> {
            // Log In Screen
            LogInScreen(
                onLogInSuccess = {
                    navController.navigate(Screen.HomeRoot) {
                        popUpTo(Screen.AuthRoot) { inclusive = true }
                    }
                },
                onForgotPassword= { navController.navigate(Screen.Auth.ForgotPassword) })
        }
    }
}

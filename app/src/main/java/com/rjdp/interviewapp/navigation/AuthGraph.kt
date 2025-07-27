package com.rjdp.interviewapp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rjdp.interviewapp.ui.screens.auth.LogInScreen
import com.rjdp.interviewapp.ui.screens.auth.SignUpScreen
import com.rjdp.interviewapp.ui.screens.auth.WelcomeScreen

fun NavGraphBuilder.authGraph(navController: NavController) {

    navigation<SubRoot.Auth>(startDestination = AuthRoot.WelcomeScreen) {

        composable<AuthRoot.WelcomeScreen> {
            // Welcome Screen
            WelcomeScreen(
                onSignUpClick = { navController.navigate(AuthRoot.SignUpScreen) },
                onLogInClick = { navController.navigate(AuthRoot.LogInScreen) }
            )
        }

        composable<AuthRoot.SignUpScreen> {
            // Sign Up Screen
            SignUpScreen(
                onSignUpSuccess = {
                    navController.navigate(HomeRoot.HomeScreen) {
                        popUpTo(SubRoot.Auth) { inclusive = true }
                    }
                }
            )
        }

        composable<AuthRoot.LogInScreen> {
            // Log In Screen
            LogInScreen(
                onLogInSuccess = {
                    navController.navigate(HomeRoot.HomeScreen) {
                        popUpTo(SubRoot.Auth) { inclusive = true }
                    }
                })
        }

        composable<AuthRoot.ForgotPasswordScreen> {
            // Forgot Password Screen
            // This screen can be implemented as needed
        }
    }

}

package com.rjdp.interviewapp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.rjdp.interviewapp.ui.screens.auth.LogInScreen
import com.rjdp.interviewapp.ui.screens.auth.SignUpScreen

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation(startDestination = "signup", route = "auth") {
        composable("signup") {
            SignUpScreen (
                onSignUpSuccess = {
                    navController.navigate("home") {
                        popUpTo("auth") { inclusive = true }
                    }
                }
            )
        }
        composable("login") {
            LogInScreen(onLogInSuccess = {
                navController.navigate("home") {
                    popUpTo("auth") { inclusive = true }
                }
            })
        }
    }
}

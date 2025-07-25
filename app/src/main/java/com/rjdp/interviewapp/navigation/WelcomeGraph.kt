package com.rjdp.interviewapp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rjdp.interviewapp.ui.screens.WelcomeScreen

fun NavGraphBuilder.welcomeGraph(navController: NavController) {
    composable("welcome") {
        WelcomeScreen(
            onLogInClick = {
                navController.navigate("login")
            },
            onSignUpClick = {
                navController.navigate("signup")
            }
        )
    }
}

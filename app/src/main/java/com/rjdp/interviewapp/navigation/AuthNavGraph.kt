package com.rjdp.interviewapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rjdp.interviewapp.ui.screens.auth.ForgetPasswordScreen
import com.rjdp.interviewapp.ui.screens.auth.LogInScreen
import com.rjdp.interviewapp.ui.screens.auth.SignUpScreen
import com.rjdp.interviewapp.ui.screens.auth.WelcomeScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(startDestination = Screen.Welcome.route, route = Screen.AuthGraph.route) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onLogInClick = { navController.navigate(Screen.Login.route) },
                onSignUpClick = { navController.navigate(Screen.SignUp.route) }
            )
        }
        composable(Screen.Login.route) {
            LogInScreen(
                onLoginSuccess = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.AuthGraph.route) { inclusive = true }
                    }
                },
                onForgotPassword = {
                    navController.navigate(Screen.ForgotPassword.route)
                }
            )
        }
        composable(Screen.SignUp.route) {
            SignUpScreen(onSignUpSuccess = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.AuthGraph.route) { inclusive = true }
                }
            })
        }
        composable(Screen.ForgotPassword.route) {
            ForgetPasswordScreen(onDone = { navController.popBackStack(Screen.Login.route, false) })
        }
    }
}

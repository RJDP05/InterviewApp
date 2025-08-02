package com.rjdp.interviewapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rjdp.interviewapp.AuthViewModel
import com.rjdp.interviewapp.ui.screens.auth.ForgetPasswordScreen
import com.rjdp.interviewapp.ui.screens.auth.LogInScreen
import com.rjdp.interviewapp.ui.screens.auth.SignUpScreen
import com.rjdp.interviewapp.ui.screens.auth.WelcomeScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController, authViewModel: AuthViewModel) {

    navigation(
        startDestination = Routes.WELCOME,
        route = Routes.AUTH_ROOT
    ) {
        composable(Routes.WELCOME) {
            WelcomeScreen(
                onLogInClick = { navController.navigate(Routes.LOGIN) },
                onSignUpClick = { navController.navigate(Routes.SIGNUP)}
            )
        }
        composable(Routes.LOGIN) {
            LogInScreen(
                onLoginClick = { email, password ->
                    authViewModel.logIn(email, password)
                },
                onForgotPasswordClick = {
                    navController.navigate(Routes.FORGOT_PASSWORD)
                }
            )
        }
        composable(Routes.SIGNUP) {
            SignUpScreen(
                onSignUpClick = { email, password ->
                    authViewModel.signUp(email, password)
                }
            )
        }
        composable(Routes.FORGOT_PASSWORD) {
            ForgetPasswordScreen(onResetClick = { email ->
                authViewModel.resetPassword(email)
            })
        }
    }
}

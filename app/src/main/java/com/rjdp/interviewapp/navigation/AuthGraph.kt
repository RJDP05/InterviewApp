//package com.rjdp.interviewapp.navigation
//
//import androidx.navigation.NavGraphBuilder
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.composable
//import androidx.navigation.navigation
//import com.rjdp.interviewapp.ui.screens.auth.LogInScreen
//import com.rjdp.interviewapp.ui.screens.auth.SignUpScreen
//import com.rjdp.interviewapp.ui.screens.auth.WelcomeScreen
//
//
//fun NavGraphBuilder.authGraph(navController: NavHostController,onLoginSuccess: () -> Unit) {
//
//    navigation(
//        route = AppScreen.AuthNav.route,
//        startDestination = AppScreen.AuthNav.Welcome.route
//    ) {
//        composable(AppScreen.AuthNav.Welcome.route) {
//            // Welcome Screen
//            WelcomeScreen(
//                onSignUpClick = {
//                    navController.navigate(AppScreen.AuthNav.Register.route) },
//                onLogInClick = {
//                    navController.navigate(AppScreen.AuthNav.Login.route) }
//            )
//        }
//
//        composable(AppScreen.AuthNav.Register.route) {
//            // Sign Up Screen
//            SignUpScreen(
//                onSignUpSuccess = {
//                    onLoginSuccess()
//                    navController.navigate(AppScreen.MainNav.route)
//                    {
//                        popUpTo(AppScreen.AuthNav.route) { inclusive = true }
//                    }
//                }
//            )
//        }
//
//        composable(AppScreen.AuthNav.Login.route) {
//            // Log In Screen
//            LogInScreen(
//                onLogInSuccess = {
//                    onLoginSuccess()
//                    navController.navigate(AppScreen.MainNav.route) {
//                        popUpTo(AppScreen.AuthNav.route) { inclusive = true }
//                    }
//                },
//                onForgotPassword= { navController.navigate(AppScreen.AuthNav.ForgotPassword.route) })
//        }
////        composable(AppScreen.AuthNav.ForgotPassword.route) {
////            ForgetPasswordScreen()
////        }
//    }
//}

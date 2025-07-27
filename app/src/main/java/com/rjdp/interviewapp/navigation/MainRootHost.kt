package com.rjdp.interviewapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import androidx.navigation.navigation
import com.rjdp.interviewapp.ui.screens.auth.WelcomeScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    val user = FirebaseAuth.getInstance().currentUser
    NavHost(
        navController = navController,
        startDestination = if (user != null) SubRoots.Auth else SubRoots.Home
    ) {
        navigation<SubRoots.Auth>(startDestination = AuthRoots.WelcomeScreen) {

            composable<AuthRoots.WelcomeScreen> {
                // Welcome Screen
                WelcomeScreen(
                    onSignUpClick = { navController.navigate(AuthRoots.SignUp) },
                    onLogInClick = { navController.navigate(AuthRoots.LogIn) }
                )
            }

            composable<AuthRoots.SignUp> {
                // Sign Up Screen
            }

            composable<AuthRoots.LogIn> {
                // Log In Screen
            }

            composable<AuthRoots.ForgotPassword> {
                // Forgot Password Screen
            }
        }

        navigation<SubRoots.Home>(startDestination = HomeRoots.Home) {

            composable<HomeRoots.Home> {
                // Home Screen
            }

            composable<HomeRoots.Profile> {
                // Profile Screen
            }

            composable<HomeRoots.Settings> {
                // Settings Screen
            }

            composable<HomeRoots.Interview> {
                // Interview Screen
            }
        }

    }
}
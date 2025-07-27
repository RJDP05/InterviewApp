package com.rjdp.interviewapp.navigation


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.google.firebase.auth.FirebaseAuth
import com.rjdp.interviewapp.ui.screens.main.HomeScreen

fun NavGraphBuilder.homeGraph(navController: NavController) {

    navigation<SubRoot.Home>(startDestination = HomeRoot.HomeScreen) {

        composable<HomeRoot.HomeScreen> {
            // Home Screen
            HomeScreen(
                onLogout =  {
                    //FirebaseAuth.getInstance().signOut()
                    navController.navigate(SubRoot.Auth) {
                        popUpTo(SubRoot.Home) { inclusive = true }
                    }
                }
            )
        }

        composable<HomeRoot.ProfileScreen> {
            // Profile Screen
        }

        composable<HomeRoot.SettingsScreen> {
            // Settings Screen
        }

        composable<HomeRoot.InterviewScreen> {
            // Interview Screen
        }
    }
}
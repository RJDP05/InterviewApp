package com.rjdp.interviewapp.navigation

import androidx.compose.material3.Scaffold
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.rjdp.interviewapp.ui.screens.main.HomeScreen

fun NavGraphBuilder.homeGraph(navController: NavController) {
    composable("home") {
        val bottomNavController = rememberNavController()

        Scaffold(
            bottomBar = BottomNavigationBar(bottomNavController)
        ) {

        }
        HomeScreen(onLogout = {
            FirebaseAuth.getInstance().signOut()
            navController.navigate("auth") {
                popUpTo("home") { inclusive = true }
            }
        })
    }
}
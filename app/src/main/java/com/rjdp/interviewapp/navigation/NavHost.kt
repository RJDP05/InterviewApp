package com.rjdp.interviewapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AppNavGraph() {
    val navController: NavHostController = rememberNavController()
    val user = FirebaseAuth.getInstance().currentUser
    NavHost(
        navController = navController,
        startDestination = if (user != null) "home" else "welcome"
    ) {
        // Welcome Screen
        welcomeGraph(navController)

        //Auth Graph
        authGraph(navController)

        //Forget Password Screen

        //Home Screen
        homeGraph(navController)


    }
}
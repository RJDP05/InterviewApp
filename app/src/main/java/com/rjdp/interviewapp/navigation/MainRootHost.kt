package com.rjdp.interviewapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import androidx.navigation.navigation
import com.rjdp.interviewapp.ui.screens.auth.LogInScreen
import com.rjdp.interviewapp.ui.screens.auth.SignUpScreen
import com.rjdp.interviewapp.ui.screens.auth.WelcomeScreen
import com.rjdp.interviewapp.ui.screens.main.HomeScreen


// Main Navigation Root Host
@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
//    val user = FirebaseAuth.getInstance().currentUser
    NavHost(
        navController = navController,
        startDestination = SubRoot.Auth
        //startDestination = if (user == null) SubRoot.Auth else SubRoot.Home
    ) {
        // Define the Auth graph
        authGraph(navController)

        //Define the Home graph
        homeGraph(navController)


    }
}
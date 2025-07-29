package com.rjdp.interviewapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


// Main Navigation Root Host
@Composable
fun RootNavGraph(
    navController: NavHostController,
    isLoggedIn: Boolean
) {
    NavHost(
        navController = navController,
        startDestination = if(isLoggedIn) Screen.HomeRoot else Screen.AuthRoot
    ) {
        // Define the Auth graph
        authGraph(navController)

        // Define the Home graph
        homeGraph(navController)

//        composable<Screen.Profile> { backStack ->
//            val dto = backStack.toRoute<Screen.Profile>()
//            ProfileScreen(userId = dto.userId)
//        }
    }

}


//    NavHost(
//        navController = navHostController,
//        startDestination = SubRoot.Home
//    ) {
//        //Define the Home graph
//
//
//        // Define the Interview graph
//        interviewGraph(navHostController)
//
//        // Define the Profile graph
//        //profileGraph(navHostController)
//
//        // Define the Settings graph
//        settingsGraph(navHostController)
//    }
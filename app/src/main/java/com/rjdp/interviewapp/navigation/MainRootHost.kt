package com.rjdp.interviewapp.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.rjdp.interviewapp.AuthState
import com.rjdp.interviewapp.AuthViewModel


@Composable
fun NavGraph(navController: NavHostController, authViewModel: AuthViewModel = viewModel()) {

    val authState by authViewModel.authState.collectAsState()

    NavHost(navController, startDestination = "router") {
        composable("router") {
            RouterScreen(authState = authState, navController = navController)
        }
        authNavGraph(navController)
        mainNavGraph(navController)
    }
}

@Composable
fun RouterScreen(
    authState: AuthState,
    navController: NavHostController
) {
    val current by navController.currentBackStackEntryAsState()
    val currentRoute = current?.destination?.route

    LaunchedEffect(authState, currentRoute) {
        if (authState == AuthState.Authenticated && currentRoute != Screen.Home.route) {
            navController.navigate(Screen.Home.route) {
                popUpTo("router") { inclusive = true }
            }
        } else if (authState == AuthState.Unauthenticated && currentRoute != Screen.Welcome.route) {
            navController.navigate(Screen.Welcome.route) {
                popUpTo("router") { inclusive = true }
            }
        }
    }
}

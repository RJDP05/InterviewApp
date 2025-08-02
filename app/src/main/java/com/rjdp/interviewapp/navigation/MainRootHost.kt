package com.rjdp.interviewapp.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.rjdp.interviewapp.AuthState
import com.rjdp.interviewapp.AuthStateHandler
import com.rjdp.interviewapp.AuthViewModel


@Composable
fun AppNavigation(authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    val authState by authViewModel.authState.collectAsState()


    AuthStateHandler(
        authState = authState,
        onRetry = { /* Implement retry logic if needed */ }
    ) {
        // Listen to auth state changes and navigate accordingly
        LaunchedEffect(authState) {
            when (authState) {
                is AuthState.Authenticated -> {
                    navController.navigate(Routes.MAIN_ROOT) {
                        popUpTo(0) { inclusive = true } // Clear entire backstack
                        launchSingleTop = true
                    }
                }
                is AuthState.Unauthenticated -> {
                    navController.navigate(Routes.AUTH_ROOT) {
                        popUpTo(0) { inclusive = true } // Clear entire backstack
                        launchSingleTop = true
                    }
                }
                else -> { /* Loading state handled by AuthStateHandler */ }
            }
        }

        NavHost(
            navController = navController,
            startDestination = when (authState) {
                is AuthState.Authenticated -> Routes.MAIN_ROOT
                is AuthState.Unauthenticated -> Routes.AUTH_ROOT
                else -> Routes.AUTH_ROOT // Default to auth while loading
            }
        ) {
            // Auth navigation graph
            authNavGraph(navController, authViewModel)

            // Main navigation graph
            mainNavGraph(navController, authViewModel)
        }
    }
}


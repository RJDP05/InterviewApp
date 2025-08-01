package com.rjdp.interviewapp.ui.screens.main

import android.R.attr.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.rjdp.interviewapp.DoubleBackToExitApp
import com.rjdp.interviewapp.navigation.BottomNavItem
import com.rjdp.interviewapp.navigation.Screen
import com.rjdp.interviewapp.navigation.mainNavGraph
import kotlin.collections.forEach
import kotlin.sequences.any

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    DoubleBackToExitApp()
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            NavHost(navController, startDestination = Screen.Home.route) {
                mainNavGraph(navController)
            }
        }
    }
}

@Composable
fun BottomNavigation(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Interview,
        BottomNavItem.Settings
    )
    
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        val currentRoute = currentDestination?.route
        
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon( imageVector = (if (item.route == currentRoute) item.selectedIcon else item.unselectedIcon)!!, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    if (item.route == currentRoute) {
                        navController.popBackStack(route = item.route, inclusive = false)
                    } else {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}

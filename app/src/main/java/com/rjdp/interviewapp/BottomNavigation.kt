//package com.rjdp.interviewapp
//
//import androidx.compose.material3.Icon
//import androidx.compose.material3.NavigationBar
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.res.stringResource
//import androidx.navigation.NavDestination.Companion.hierarchy
//import androidx.navigation.NavGraph.Companion.findStartDestination
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.currentBackStackEntryAsState
//import com.rjdp.interviewapp.navigation.AppScreen
//
//@Composable
//fun BottomBar(navController: NavHostController) {
//    val items = listOf(
//        AppScreen.MainNav.Home,
//        AppScreen.MainNav.Interview,
//        AppScreen.MainNav.Settings
//    )
//
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentDestination = navBackStackEntry?.destination
//
//    NavigationBar {
//        items.forEach { destination ->
//            val isSelected = currentDestination?.hierarchy
//                ?.any { it.route == destination.route } == true
//
//            NavigationBarItem(
//                selected = isSelected,
//                label = { Text(destination.titleRes?.let { stringResource(it) } ?: destination.route) },
//                icon = {
//                    Icon(
//                        imageVector = if (isSelected)
//                            destination.selectedIcon!!
//                        else
//                            destination.unSelectedIcon!!,
//                        contentDescription = destination.titleRes?.let { stringResource(it) }
//                    )
//                },
//                onClick = {
//                    navController.navigate(destination.route) {
//                        popUpTo(navController.graph.findStartDestination().id) {
//                            saveState = true
//                        }
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                }
//            )
//        }
//    }
//}
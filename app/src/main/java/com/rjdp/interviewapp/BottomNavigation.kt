package com.rjdp.interviewapp



import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.rjdp.interviewapp.navigation.BottomNavigationItems

@Composable
fun BottomBar(navController: NavController){
    val items = remember {
        listOf(
            BottomNavigationItems.Home,
            BottomNavigationItems.Interview,
            BottomNavigationItems.Settings
        )
    }

    NavigationBar{
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { screen ->
            val isSelected = currentDestination?.hierarchy?.any{ it.hasRoute(screen.route::class) } == true
            NavigationBarItem(
                selected = isSelected,
                label = {
                    Text(screen.name)
                },
                icon = {
                    Icon(
                        imageVector = if (isSelected) screen.selectedIcon!! else screen.unSelectedIcon!!,
                        contentDescription = screen.name
                    )
                },

                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}

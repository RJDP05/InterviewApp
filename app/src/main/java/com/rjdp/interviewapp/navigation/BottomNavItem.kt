package com.rjdp.interviewapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
){
    object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    object Calendar : BottomNavItem("calendar", Icons.Default.CalendarMonth, "Calendar")
    object Settings : BottomNavItem("settings", Icons.Default.Settings, "Settings")
}
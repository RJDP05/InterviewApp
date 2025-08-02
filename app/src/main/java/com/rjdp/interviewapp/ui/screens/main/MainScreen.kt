package com.rjdp.interviewapp.ui.screens.main

import android.R.attr.fontWeight
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rjdp.interviewapp.DoubleBackToExitApp
import com.rjdp.interviewapp.navigation.bottomNavItems
import kotlin.collections.forEach

@Composable
fun MainScreenWithBottomNav(
    currentRoute: String,
    onNavigate: (String) -> Unit,
    onSignOut: () -> Unit,
    content: @Composable () -> Unit
) {
    DoubleBackToExitApp()
    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            ) {
                bottomNavItems.forEach { item ->
                    val isSelected = currentRoute == item.route
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        },
                        label = {
                            Text(
                                text = item.title,
//                                style = if (isSelected) {
//                                    fontWeight = FontWeight.Bold
//                                } else {
//                                    MaterialTheme.typography.caption
//                                }
                            )
                        },
                        selected = isSelected,
                        onClick = {
                            if (!isSelected) {
                                onNavigate(item.route)
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            content()
        }
    }
}

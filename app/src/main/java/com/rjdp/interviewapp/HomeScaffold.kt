package com.rjdp.interviewapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rjdp.interviewapp.navigation.Screen
import com.rjdp.interviewapp.ui.screens.main.HomeScreen
import com.rjdp.interviewapp.ui.screens.main.InterviewScreen
import com.rjdp.interviewapp.ui.screens.main.SettingsScreen
import kotlinx.coroutines.sync.Mutex

@Composable
fun HomeScaffold(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
            .padding(innerPadding),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            Text(text = "Home Scaffold")
        }
//        NavHost(
//            navController = navController,
//            startDestination = Screen.Home.Main,
//            modifier = Modifier.padding(innerPadding)
//        ) {
//            composable<Screen.Home.Main> { HomeScreen( { navController.navigate(Screen.AuthRoot){
//                popUpTo(Screen.HomeRoot) { inclusive = true }
//            } } ) }
//                //onPhotoClick = { navController.navigate(Screen.Profile(userId = "me"))}
//            composable<Screen.Home.Interview> { InterviewScreen() }
//            composable<Screen.Home.Settings> { SettingsScreen() }
//        }
    }
}

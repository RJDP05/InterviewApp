package com.rjdp.interviewapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.rjdp.interviewapp.navigation.NavGraph
import com.rjdp.interviewapp.ui.theme.InterviewAppTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            InterviewAppTheme {
                DemoNavigationApp()
            }
        }
    }
}

@Composable
fun DemoNavigationApp() {
    val navController = rememberNavController()
    NavGraph(navController = navController)
}
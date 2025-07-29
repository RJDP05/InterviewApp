package com.rjdp.interviewapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.rjdp.interviewapp.navigation.RootNavGraph

@Composable
fun App() {
    val navController = rememberNavController()
    RootNavGraph(navController = navController, false)
}
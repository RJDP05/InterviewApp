package com.rjdp.interviewapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rjdp.interviewapp.navigation.AppNavigation
import com.rjdp.interviewapp.ui.theme.InterviewAppTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            InterviewAppTheme {
                val authViewModel: AuthViewModel = viewModel()
                AppNavigation(authViewModel = authViewModel)
            }
        }
    }
}

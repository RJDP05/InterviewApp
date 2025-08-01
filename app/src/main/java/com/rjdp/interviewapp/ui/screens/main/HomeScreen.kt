package com.rjdp.interviewapp.ui.screens.main

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rjdp.interviewapp.AuthState
import com.rjdp.interviewapp.AuthViewModel
import com.rjdp.interviewapp.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: AuthViewModel = viewModel(),
    onSignOut: () -> Unit
){
    val authState by viewModel.authState.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(text = "Hello,\n name")},
                navigationIcon = {
                    IconButton(onClick = { /* Navigate */ }) {
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = "Person Image"
                    )
                }},
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "Notifications"
                        )
                    }
                }
            )
        }
    ){
        innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Button(
                onClick = {viewModel.signOut()}
            )
            {
                if (authState is AuthState.Loading) {
                    CircularProgressIndicator(Modifier.size(20.dp), strokeWidth = 2.dp, color = Color.White)
                } else {
                    Text("LOG OUT")
                }
            }
            when (authState) {
                is AuthState.Error -> Text(
                    (authState as AuthState.Error).message,
                    color = MaterialTheme.colorScheme.error
                )
                else -> {}
            }

        }
    }

    LaunchedEffect(authState) {
        if (authState is AuthState.Authenticated) {
            onSignOut()
        }
    }
}




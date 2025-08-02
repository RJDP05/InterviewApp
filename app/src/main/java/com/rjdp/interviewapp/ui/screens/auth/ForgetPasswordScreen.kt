package com.rjdp.interviewapp.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.rjdp.interviewapp.AuthState
import com.rjdp.interviewapp.AuthViewModel
import com.rjdp.interviewapp.R

@Composable
fun ForgetPasswordScreen(
    onResetClick: (String) -> Unit
) {
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Illustration Image
        Image(
            painter = painterResource(id = R.drawable.fp),
            contentDescription = "Forget Password Image",
            modifier = Modifier.width(250.dp),
            alpha = DefaultAlpha,
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            textStyle = TextStyle(color = Color.Black),
            label = { Text("Enter Email ID") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Sign In Button
        Button(
            onClick = {
                onResetClick(email.trim())
            },
//            enabled = authState !is AuthState.Loading,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("CONTINUE", fontWeight = FontWeight.Bold)
//            if (authState is AuthState.Loading) {
//                CircularProgressIndicator(Modifier.size(20.dp), strokeWidth = 2.dp, color = Color.White)
//            } else {
//                Text("CONTINUE")
//            }
        }
    }

//    LaunchedEffect(authState) {
//        if (authState is AuthState.Unauthenticated) {
//            // Assuming viewModel resets to Unauthenticated on success
//            onDone()
//        }
//    }
}

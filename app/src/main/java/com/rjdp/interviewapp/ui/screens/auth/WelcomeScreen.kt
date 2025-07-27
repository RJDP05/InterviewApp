package com.rjdp.interviewapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rjdp.interviewapp.R


@Composable
fun WelcomeScreen(
    onSignUpClick: () -> Unit,
    onLogInClick: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        // Illustration Image
        Image(
            painter = painterResource(id = R.drawable.welcome),
            contentDescription = "SignIn Image",
            modifier = Modifier.width(280.dp),
            alpha = DefaultAlpha,
        )

        Spacer(modifier = Modifier.height(26.dp))

        Text("Get Ready to Practice, Improve and Ace Your Interviews. " +
                "Let’s Help You Put Your Best Foot Forward.",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(26.dp))
        // Sign Up Button
        Button(
            onClick = {
            //onSignInClick(email, password)
                onSignUpClick },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("CREATE AN ACCOUNT", fontWeight = FontWeight.Bold)
        }

        // Or divider
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 24.dp)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "  OR  ",
                color = Color.Gray,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        // Log In Button
        Button(
            onClick = {
            //onSignInClick(email, password)
                onLogInClick
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("ALREADY HAVE AN ACCOUNT", fontWeight = FontWeight.Bold)
        }
    }
}

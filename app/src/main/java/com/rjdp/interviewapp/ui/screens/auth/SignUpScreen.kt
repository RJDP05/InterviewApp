package com.rjdp.interviewapp.ui.screens.auth


import android.widget.Toast
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import com.rjdp.interviewapp.R

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
//    onSignInClick: (String, String) -> Unit = {},
    onSignUpSuccess: () -> Unit
) { val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Illustration Image
        Image(
            painter = painterResource(id = R.drawable.signin),
            contentDescription = "SignIn Image",
            modifier = Modifier.width(230.dp),
            alpha = DefaultAlpha,
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(color = Color.Black),
            label = { Text("Enter Email ID") },
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            textStyle = TextStyle(color = Color.Black),
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon = if (isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility
                val description = if (isPasswordVisible) "Hide password" else "Show password"
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(imageVector = icon, contentDescription = description)
                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(26.dp))

        // Sign In Button
        Button(
            onClick = {onSignUpSuccess()},
//                { FirebaseAuth.getInstance()
//                    .createUserWithEmailAndPassword(email, password)
//                    .addOnSuccessListener { onSignUpSuccess() }
//                    .addOnFailureListener { Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()}
//                      },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("SIGN IN", fontWeight = FontWeight.Bold)
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

        // Google Sign In Button
        Button(
            onClick = {  },
//            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
//            elevation = ButtonDefaults.elevation(4.dp)
        ) {
            // Optionally add Google icon here
            Image(painter = painterResource(id = R.drawable.google_logo),
                contentDescription = "Google Image",
                alpha = DefaultAlpha,)
            Spacer(modifier = Modifier.width(8.dp))
            Text("SIGN IN WITH GOOGLE", fontWeight = FontWeight.Bold)
        }
    }
}

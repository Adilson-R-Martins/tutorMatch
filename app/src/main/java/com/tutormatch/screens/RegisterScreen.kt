package com.tutormatch.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.tutormatch.R

@Composable
fun RegisterScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    val customPurple = colorResource(id = R.color.purple_700)
    val customPurple2 = colorResource(id = R.color.purple_200)

    val auth = FirebaseAuth.getInstance()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.background(Color.White)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.icon),
                modifier = Modifier.size(80.dp),
                contentDescription = stringResource(id = R.string.icon)
            )
            Text(
                text = "TutorMatch",
                modifier = Modifier.padding(30.dp)
            )
            Spacer(Modifier.height(60.dp))
            TextField(
                value = email,
                onValueChange = {
                    email = it
                    showError = false
                },
                label = { Text(text = stringResource(id = R.string.email)) }
            )
            Spacer(Modifier.height(16.dp))
            TextField(
                value = password,
                onValueChange = {
                    password = it
                    showError = false
                },
                label = { Text(text = stringResource(id = R.string.password)) },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(Modifier.height(24.dp))

            Button(
                onClick = {
                    if (email.isNotBlank() && password.isNotBlank()) {
                        auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    // Registro exitoso, navega a la pantalla de inicio de sesión
                                    navController.navigate("login")
                                } else {
                                    // Registro fallido, muestra un mensaje de error
                                    showError = true
                                    errorMessage = task.exception?.message ?: "Unknown error"
                                }
                            }
                    } else {
                        // Muestra un mensaje de error si el correo electrónico o la contraseña están en blanco
                        showError = true
                        errorMessage = "Por favor, introduce un correo electrónico y una contraseña válidos"
                    }
                },
                colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = customPurple)
            ) {
                Text(
                    text = "Registrar",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            if (showError) {
                Text(
                    text = errorMessage,
                    color = Color.Red
                )
            }
        }
    }
}

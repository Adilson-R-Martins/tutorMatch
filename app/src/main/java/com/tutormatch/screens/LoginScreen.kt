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
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("E-mail ou Senha inválidos") }
    val auth = FirebaseAuth.getInstance()
    val customPurple = colorResource(id = R.color.purple_700)
    val customPurple2 = colorResource(id = R.color.purple_200)

    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(50.dp)) // Espaço para compensar a altura da barra superior
            Image(
                painter = painterResource(id = R.drawable.icon),
                modifier = Modifier.size(80.dp),
                contentDescription = stringResource(id = R.string.icon)
            )
            Text(
                text = "TutorMatch",
                modifier = Modifier.padding(50.dp)
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
                        auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    navController.navigate("menu")
                                } else {
                                    showError = true
                                    errorMessage = task.exception?.message ?: "Unknown error"
                                }
                            }
                    } else {
                        showError = true
                        errorMessage = "Por favor, introduzir um e-mail e senha válidos"
                    }
                },
                colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = customPurple) // Define a cor do texto do botão como branco
            ) {
                Text(
                    text = stringResource(id = R.string.entrar),
                    fontWeight = FontWeight.Bold
                )
            }
            if (showError) {
                Text(
                    text = errorMessage,
                    color = customPurple2
                )
            }
            Button(
                onClick = {
                    navController.navigate("register")
                },
                colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = customPurple) // Define a cor do texto do botão como branco
            ) {
                Text(
                    text = "Registrar"
                )
            }
        }
    }
}

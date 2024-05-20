package com.tutormatch.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tutormatch.R

@Composable
fun MatchingScreen(navController: NavHostController) {
    // Aqui você teria uma lista de perfis de professores e alunos
    val profiles = listOf(
        Profile(name = "Professor 1", specialization = "Matemática", description = "Descrição do perfil", photo = R.drawable.skills),
        Profile(name = "Professor 2", specialization = "Física", description = "Descrição do perfil", photo = R.drawable.resources),
        // Adicione mais perfis conforme necessário
    )

    // Lógica para rastrear o perfil atual sendo exibido
    var currentProfileIndex by remember { mutableStateOf(0) }
    val currentProfile = profiles.getOrNull(currentProfileIndex)

    if (currentProfile != null) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Exibe a foto do perfil
            Image(
                painter = painterResource(id = currentProfile.photo),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Exibe informações do perfil
            Text(text = currentProfile.name, fontWeight = FontWeight.Bold)
            Text(text = currentProfile.specialization)
            Text(text = currentProfile.description)
            Spacer(modifier = Modifier.height(16.dp))
            // Botões para indicar interesse ou desinteresse
            Row {
                IconButton(onClick = { /* Lógica para indicar interesse */ }) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = "Like")
                }
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(onClick = { /* Lógica para indicar desinteresse */ }) {
                    Icon(Icons.Default.Close, contentDescription = "Dislike")
                }
            }
        }
    } else {
        // Exibe uma mensagem quando não há mais perfis para mostrar
        Text("Sem mais perfis para exibir")
    }
}

data class Profile(
    val name: String,
    val specialization: String,
    val description: String,
    val photo: Int // Referência para o recurso da foto do perfil
)

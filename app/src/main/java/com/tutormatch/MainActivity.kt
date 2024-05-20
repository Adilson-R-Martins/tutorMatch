package com.tutormatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tutormatch.screens.LoginScreen
import com.tutormatch.ui.theme.TutorMatchTheme
import com.google.firebase.auth.FirebaseAuth
import com.tutormatch.screens.MatchingScreen
import com.tutormatch.screens.MenuScreen
import com.tutormatch.screens.ProfileScreen
import com.tutormatch.screens.RegisterScreen

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

        setContent {
            TutorMatchTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable(route = "login") { LoginScreen(navController) }
                        composable(route = "menu") { MenuScreen(navController, "User Name")}
                        composable(route = "register") { RegisterScreen(navController) }
                        composable(route = "profile") { ProfileScreen(navController) }
                        composable(route = "Matching") { MatchingScreen(navController) }
                        composable(route = "profile") { ProfileScreen(navController) }

                    }
                }
            }
        }
    }
}

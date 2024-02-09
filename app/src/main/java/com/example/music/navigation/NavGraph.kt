package com.example.music.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.music.screens.albumsScreen.AlbumsScreen
import com.example.music.screens.loginScreen.LoginScreen
import com.example.music.screens.signupscreen.SignupScreen
import com.example.music.screens.tracksScreen.TracksScreen

enum class Screen {
    LOGIN,
    SIGNUP,
    ALBUMS,
    TRACKS
}
sealed class NavigationItem(val route: String) {
    data object Login : NavigationItem(Screen.LOGIN.name)
    data object Signup : NavigationItem(Screen.SIGNUP.name)
    data object Albums : NavigationItem(Screen.ALBUMS.name)
    data object Tracks : NavigationItem(Screen.TRACKS.name)
}

@Composable
fun NavigationHost(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = NavigationItem.Login.route){
        composable(NavigationItem.Login.route){
            LoginScreen(navHostController)
        }
        composable(NavigationItem.Signup.route){
            SignupScreen(navHostController)
        }
        composable(NavigationItem.Albums.route){
            AlbumsScreen(navHostController)
        }

        composable(NavigationItem.Tracks.route){
            TracksScreen(navHostController)
        }
    }
}
package com.example.music

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.compose.rememberNavController
import com.example.music.navigation.NavigationHost
import com.example.music.screens.loginScreen.LoginScreen
import com.example.music.ui.theme.MusicTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainActivity : ComponentActivity() {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "musicSettings")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MusicTheme {
                val navHostController = rememberNavController()
                NavigationHost(navHostController = navHostController)
            }
        }
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        window.navigationBarColor = android.graphics.Color.TRANSPARENT
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MusicTheme {
    }
}
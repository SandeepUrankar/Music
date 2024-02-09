package com.example.music.screens.loginScreen

import android.provider.MediaStore.Audio.Albums
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import com.example.music.R
import com.example.music.components.OutlinedPasswordInputField
import com.example.music.components.OutlinedTextInputField
import com.example.music.navigation.NavigationItem


@Composable
fun LoginScreen(navHostController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {

        val username = remember {
            mutableStateOf("")
        }
        val password = remember {
            mutableStateOf("")
        }

        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 46.dp, vertical = 52.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.headphones),
                contentDescription = "Headphones logo",
                modifier = Modifier.size(100.dp),
                tint = MaterialTheme.colorScheme.surfaceVariant
            )


            Text(
                text = "Welcome back, Please login to continue",
                style = TextStyle(
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(top = 24.dp)
            )

            OutlinedTextInputField(value = username, label = "Username")
            OutlinedPasswordInputField(value = password, label = "Password")

            Button(
                onClick = {
                          navHostController.navigate(NavigationItem.Albums.route)
                          },
                modifier = Modifier
                    .padding(top = 34.dp)
                    .width(100.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Text(
                    text = "Login",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            TextButton(modifier = Modifier.padding(top = 24.dp), onClick = {
                navHostController.navigate(
                    NavigationItem.Signup.route
                )
            }) {
                Text(
                    text = "New User? Sign up",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
            }
        }

    }
}


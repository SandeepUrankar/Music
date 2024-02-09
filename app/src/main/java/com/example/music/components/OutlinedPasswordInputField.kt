package com.example.music.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.music.R

@Composable
fun OutlinedPasswordInputField(value: MutableState<String>, label: String) {
    var passwordVisible by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        label = { Text(text = "Password", fontSize = 16.sp) },
        value = value.value,
        onValueChange = {
            value.value = it
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 26.dp),
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.colors(
            focusedLabelColor = MaterialTheme.colorScheme.surfaceVariant,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,

            ),
        trailingIcon = {

            val icon =
                if (passwordVisible) painterResource(id = R.drawable.visibility_off) else painterResource(
                    id = R.drawable.visibility
                )
            IconButton(onClick = {
                passwordVisible = !passwordVisible
            }) {
                Icon(icon, "password visible")
            }
        }
    )
}
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.music.R

@Composable
fun OutlinedTextInputField(
    value: MutableState<String>,
    label: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        label = { Text(text = "Username", fontSize = 16.sp) },
        value = value.value,
        onValueChange = {
            value.value = it
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 26.dp),
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.colors(
            focusedLabelColor = MaterialTheme.colorScheme.surfaceVariant,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            )
    )
}
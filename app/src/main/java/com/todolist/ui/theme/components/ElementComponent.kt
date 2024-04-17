package com.todolist.ui.theme.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("RememberReturnType")
@Composable
fun ElementComponent(modifier: Modifier = Modifier) {

    // variables para los estados/vigilancia
    val colorFondo = remember { mutableStateOf(Color.LightGray) }
    val descripcion = remember { mutableStateOf("Descripcion") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorFondo.value)
            .clickable {
                colorFondo.value = Green
                descripcion.value = "¡Tarea Completada!"
            },
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        // Titulo
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .align(Alignment.CenterVertically)
                .padding(8.dp),
            text = "Titulo"
        )

        // Descripcion
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .align(Alignment.CenterVertically)
                .padding(8.dp),
            text = descripcion.value
        )

    }
}

@Preview(showBackground = true)
@Composable
fun ElementComponentPreview() {
    ElementComponent()
}
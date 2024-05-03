package com.neftaly.todolist.ui.components.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neftaly.todolist.ui.data.ListaTareas
import com.neftaly.todolist.ui.model.plantilla
import kotlinx.coroutines.delay

@Composable
fun AddScreen() {

    // variables para los datos que obtenemos
    val titleTask = remember { mutableStateOf("") }
    val descriptionTask = remember { mutableStateOf("") }

    // variable de error
    val errorMessage = remember { mutableStateOf("") }

    // variable de la snackbar
    val notificacion = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Add some Task Papu", fontSize = 24.sp, color = Color.Blue)

            TextField(modifier = Modifier.fillMaxWidth(),
                value = titleTask.value,
                onValueChange = { titleTask.value = it },
                label = { Text("Title") })

            TextField(modifier = Modifier.fillMaxWidth(),
                value = descriptionTask.value,
                onValueChange = { descriptionTask.value = it },
                label = { Text("Description") })

            // logica del error
            if (errorMessage.value.isNotEmpty()) {
                Text(text = errorMessage.value, color = Color.Red)
            }

            Button(modifier = Modifier.fillMaxWidth(), onClick = {

                // verificamos si los campos estan vacios
                if (titleTask.value.isBlank() || descriptionTask.value.isBlank()) {
                    errorMessage.value = "Rellene ambos campos"
                } else {
                    // almacenamos los datos
                    val newTask =
                        plantilla(
                            mutableStateOf(titleTask.value),
                            mutableStateOf(descriptionTask.value),
                            mutableStateOf(false)
                        )
                    ListaTareas.value.add(newTask)

                    // limpiamos los text field
                    titleTask.value = ""
                    descriptionTask.value = ""
                    errorMessage.value = ""

                    // mostrar la notificacion
                    notificacion.value = true
                }
            }) {
                Text("Hecho")
            }
            if (notificacion.value) {
                Snackbar(
                    modifier = Modifier,
                    action = {
                        TextButton(onClick = { notificacion.value = false }) {}
                    }
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        text = "Tarea añadida"
                    )
                }

                // intervalo
                LaunchedEffect(key1 = notificacion.value) {
                    delay(3000)
                    notificacion.value = false
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
private fun AddScreenPreview() {
    AddScreen()
}
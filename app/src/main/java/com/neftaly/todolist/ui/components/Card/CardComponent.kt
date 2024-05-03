package com.neftaly.todolist.ui.components.Card

import EditionComponent
import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neftaly.todolist.ui.model.plantilla

@Composable
fun CardComponent(modifier: Modifier = Modifier, task: plantilla) {
    // variables del cuadro de dialogo
    val (editWindow, setShowDialog) = remember { mutableStateOf(false) }

    // componente de edicion
    EditionComponent(
        task = task,
        showDialog = editWindow,
        onClose = { setShowDialog(false) },
        onConfirm = { title, description ->
            task.title.value = title
            task.description.value = description
        }
    )

    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (task.state.value) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.surfaceVariant,
        ), modifier = modifier
            .size(width = 300.dp, height = 75.dp)
            .padding(4.dp)
            .clickable { setShowDialog(true) }
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(start = 20.dp, top = 2.dp, end = 2.dp, bottom = 2.dp)
            ) {
                Text(text = task.title.value)

                // logica de la descripcion
                Text(
                    text = if (task.state.value) "Compleado" else task.description.value
                )
            }

            // Checkbox
            Checkbox(
                modifier = Modifier
                    .padding(end = 20.dp),
                checked = task.state.value,
                onCheckedChange = { task.state.value = it }
            )
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
private fun CardComponentPreview() {
    val task =
        plantilla(mutableStateOf("Tarea"), mutableStateOf("descripcion"), mutableStateOf(false))
    CardComponent(modifier = Modifier, task = task)
}
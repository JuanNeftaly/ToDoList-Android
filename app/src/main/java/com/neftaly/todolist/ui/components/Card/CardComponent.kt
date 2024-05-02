package com.neftaly.todolist.ui.components.Card

import android.annotation.SuppressLint
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neftaly.todolist.ui.model.plantilla

@Composable
fun CardComponent(modifier: Modifier, task: plantilla) {

    Card(colors = CardDefaults.cardColors(
        containerColor = if (task.state.value) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.surfaceVariant,
    ), modifier = modifier
        .size(width = 300.dp, height = 75.dp)
        .padding(4.dp))
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(2.dp)
            ) {
                Text(text = task.title.value)

                // logica de la descripcion
                Text(
                    text = if (task.state.value) "Compleado" else task.description.value
                )
            }

            // Checkbox
            Checkbox(
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
package com.neftaly.todolist.ui.components.Card

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
    ),
        modifier = Modifier
            .size(width = 300.dp, height = 75.dp)
            .padding(4.dp)
            .clickable { if (!task.state.value) task.state.value = true }) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = task.title, modifier = Modifier.padding(2.dp))

            // logica de la descripcion
            Text(
                text = if (task.state.value) "Compleado" else task.description,
                modifier = Modifier.padding(2.dp)
            )
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
private fun CardComponentPreview() {
    val task = plantilla("Besar A Primi", "Tengo que besar a primi", mutableStateOf(false))
    CardComponent(modifier = Modifier, task = task)
}
package com.neftaly.todolist.ui.components.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.neftaly.todolist.ui.model.plantilla

@Composable
fun EditScreen() {

    Column {
        Text(text = "PINGA")
    }
}

fun onTaskUpdated(task: plantilla) {

}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EditScreenPreview() {
    EditScreen()
}

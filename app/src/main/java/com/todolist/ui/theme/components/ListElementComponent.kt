package com.todolist.ui.theme.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ListElementComponent() {
    LazyColumn(

    ) {
        // aqui vamos a iterar los elementos

    }
}

@Preview(showBackground = true)
@Composable
private fun ListElementComponentPreview() {
    ListElementComponent()
}
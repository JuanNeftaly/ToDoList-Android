package com.neftaly.todolist.ui.components.Screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TaskScreen() {
    Text(text = "Panytalla de inicioi")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview(){
    TaskScreen()
}
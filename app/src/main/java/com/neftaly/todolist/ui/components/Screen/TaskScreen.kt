package com.neftaly.todolist.ui.components.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.neftaly.todolist.ui.components.BottomNavBar.ScreenRoute
import com.neftaly.todolist.ui.components.Card.CardComponent
import com.neftaly.todolist.ui.data.ListaTareas
import com.neftaly.todolist.ui.model.plantilla

@Composable
fun TaskScreen() {

    // navegacion
    val navController = rememberNavController()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Task", fontSize = 30.sp, color = Color.Blue)

            LazyColumn() {
                // aqui vamos a mandar las task
                itemsIndexed(ListaTareas.value) { index, item ->
                    CardComponent(
                        modifier = Modifier.fillMaxWidth(),
                        task = item,
                        onLongPress = {
                            // logica de navegacion
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    TaskScreen()
}
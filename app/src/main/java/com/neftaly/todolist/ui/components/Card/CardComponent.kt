package com.neftaly.todolist.ui.components.Card

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardComponent(modifier: Modifier, title: String, description: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 300.dp, height = 75.dp)
            .padding(4.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = title,
                modifier = Modifier
                    .padding(2.dp)
            )

            Text(
                text = description,
                modifier = Modifier
                    .padding(2.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun CardComponentPreview() {
    CardComponent(
        modifier = Modifier,
        title = "Besar A Primi",
        description = "Tengo que besar a primi en los labios para el viernes"
    )
}
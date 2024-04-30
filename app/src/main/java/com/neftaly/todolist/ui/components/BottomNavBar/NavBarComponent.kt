package com.neftaly.todolist.ui.components.BottomNavBar

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// funcion de la navbar
@Composable
fun NavBarComponent(
    items: List<NavBarItem>, currentRoute: String?, onClick: (NavBarItem) -> Unit
) {
    NavigationBar() {
        items.forEachIndexed { index, navBarItem ->
            NavigationBarItem(selected = currentRoute == navBarItem.route,
                onClick = { onClick(navBarItem) },
                icon = {
                    Icon(
                        imageVector = if (currentRoute == navBarItem.route) navBarItem.selectedIcon
                        else navBarItem.unSelectedIcon, contentDescription = navBarItem.title,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(text = navBarItem.title)
                })
        }
    }
}
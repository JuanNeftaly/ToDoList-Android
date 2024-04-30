package com.neftaly.todolist.ui.components.BottomNavBar

import androidx.compose.ui.graphics.vector.ImageVector

// las cosas que necesita nuestra navbar
data class NavBarItem(
    val title: String,
    val route: String,
    var selectedIcon: ImageVector,
    var unSelectedIcon: ImageVector
)

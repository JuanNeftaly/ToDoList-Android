package com.neftaly.todolist.ui.components.BottomNavBar

sealed class ScreenRoute(var route:String) {
    data object Home : ScreenRoute("home")
    data object Add : ScreenRoute("add")
    data object Profile : ScreenRoute("profile")
    data object Edit: ScreenRoute("edit/{taskIndex}")
}
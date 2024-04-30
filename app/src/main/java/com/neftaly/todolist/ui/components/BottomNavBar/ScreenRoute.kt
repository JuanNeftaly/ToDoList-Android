package com.neftaly.todolist.ui.components.BottomNavBar

sealed class ScreenRoute(var route:String) {
    object Home : ScreenRoute("home")
    object Add : ScreenRoute("add")
    object Profile : ScreenRoute("profile")
}
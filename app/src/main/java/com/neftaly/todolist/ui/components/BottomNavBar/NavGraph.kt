package com.neftaly.todolist.ui.components.BottomNavBar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.neftaly.todolist.ui.components.Screen.AddScreen
import com.neftaly.todolist.ui.components.Screen.EditScreen
import com.neftaly.todolist.ui.components.Screen.ProfileScreen
import com.neftaly.todolist.ui.components.Screen.TaskScreen

@Composable
fun NavBarGraph(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.Home.route) {
        composable(ScreenRoute.Home.route){
            TaskScreen()
        }
        composable(ScreenRoute.Add.route){
            AddScreen()
        }
        composable(ScreenRoute.Profile.route){
            ProfileScreen()
        }

        // test
        composable(ScreenRoute.Edit.route){
            EditScreen()
        }
    }
}
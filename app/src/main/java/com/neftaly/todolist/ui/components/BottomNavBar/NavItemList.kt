package com.neftaly.todolist.ui.components.BottomNavBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.neftaly.todolist.R

@Composable
fun NavBarItemList(): List<NavBarItem> {
    return listOf(
        NavBarItem(
            stringResource(id = R.string.navbar_home),
            ScreenRoute.Home.route,
            ImageVector.vectorResource(id = R.drawable.task_selected),
            ImageVector.vectorResource(id = R.drawable.task_unselected)
        ),
        NavBarItem(
            stringResource(id = R.string.navbar_add),
            ScreenRoute.Add.route,
            ImageVector.vectorResource(id = R.drawable.agregar_selected),
            ImageVector.vectorResource(id = R.drawable.agregar_unselected)
        )
    )
}

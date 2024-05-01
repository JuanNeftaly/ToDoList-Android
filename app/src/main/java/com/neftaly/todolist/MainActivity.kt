package com.neftaly.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.neftaly.todolist.ui.components.BottomNavBar.NavBarComponent
import com.neftaly.todolist.ui.components.BottomNavBar.NavBarGraph
import com.neftaly.todolist.ui.components.BottomNavBar.NavBarItemList
import com.neftaly.todolist.ui.theme.ToDoListTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListTheme {
                // variables para la navbar
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute: String? = navBackStackEntry?.destination?.route
                val navItems = NavBarItemList()

                // aqui va en la cuestion
                Scaffold(
                    topBar = {
                        val InstitutionalBlue = Color(0xFF0D47A1) // Define your color here
                        val BackgroundGray = Color(0xFFBDBDBD) // Define your color here
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = InstitutionalBlue,
                                titleContentColor = BackgroundGray,
                            ), title = {
                                Text(stringResource(id = R.string.app_name))
                            }
                        )
                    }, bottomBar = {
                        NavBarComponent(
                            items = navItems, currentRoute = currentRoute
                        ) { currentNavigationItem ->
                            navController.navigate(currentNavigationItem.route) {
                                navController.graph.startDestinationRoute?.let { startDestinationRoute ->
                                    popUpTo(startDestinationRoute) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                ) { innerPadding ->
                    NavBarGraph(
                        navController = navController, innerPadding = innerPadding
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainActivityPreview() {
    ToDoListTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute: String? = navBackStackEntry?.destination?.route
        val navItems = NavBarItemList()

        Scaffold(
            topBar = {
                val InstitutionalBlue = Color(0xFF0D47A1)
                val BackgroundGray = Color(0xFFBDBDBD)
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = InstitutionalBlue, titleContentColor = BackgroundGray,
                    ), title = {
                        Text(stringResource(id = R.string.app_name))
                    }
                )
            }, bottomBar = {
                NavBarComponent(
                    items = navItems, currentRoute = currentRoute
                ) { currentNavigationItem ->
                    navController.navigate(currentNavigationItem.route) {
                        navController.graph.startDestinationRoute?.let { startDestinationRoute ->
                            popUpTo(startDestinationRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        ) { innerPadding ->
            NavBarGraph(
                navController = navController, innerPadding = innerPadding
            )
        }
    }
}
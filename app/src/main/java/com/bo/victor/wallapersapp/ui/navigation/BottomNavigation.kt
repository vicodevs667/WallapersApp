package com.bo.victor.wallapersapp.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

/****
 * Project: WallapersApp
 * From: com.bo.victor.wallapersapp.ui.navigation
 * Created by: Victor Sanjines Lopez on 19/3/2025
 * More info: www.victorsanjines.com.bo
 * All rights reserved 2025
 ****/
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(NavScreen.Home, NavScreen.Gallery, NavScreen.Settings)
    NavigationBar {
        val currentRoute = currentRoute(navController)
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.title) },
                label = { Text(text = screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String {
    return navController.currentBackStackEntryAsState().value?.destination?.route ?: ""
}

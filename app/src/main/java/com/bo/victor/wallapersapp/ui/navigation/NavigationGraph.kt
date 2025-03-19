package com.bo.victor.wallapersapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.bo.victor.wallapersapp.ui.screens.GalleryScreen
import com.bo.victor.wallapersapp.ui.screens.HomeScreen
import com.bo.victor.wallapersapp.ui.screens.SettingsScreen

/****
 * Project: WallapersApp
 * From: com.bo.victor.wallapersapp.ui.navigation
 * Created by: Victor Sanjines Lopez on 19/3/2025
 * More info: www.victorsanjines.com.bo
 * All rights reserved 2025
 ****/
@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(navController, startDestination = NavScreen.Home.route, modifier = modifier) {
        composable(NavScreen.Home.route) { HomeScreen(navController) }
        composable(NavScreen.Gallery.route) { GalleryScreen(navController) }
        composable(NavScreen.Settings.route) { SettingsScreen(navController) }
    }
}
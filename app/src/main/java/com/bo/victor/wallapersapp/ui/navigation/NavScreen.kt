package com.bo.victor.wallapersapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.ui.graphics.vector.ImageVector

/****
 * Project: WallapersApp
 * From: com.bo.victor.wallapersapp.ui.navigation
 * Created by: Victor Sanjines Lopez on 19/3/2025
 * More info: www.victorsanjines.com.bo
 * All rights reserved 2025
 ****/
sealed class NavScreen(val route: String, val title: String, val icon: ImageVector) {
    object Home : NavScreen("home", "Inicio", Icons.Filled.Home)
    object Gallery : NavScreen("gallery", "Galería", Icons.Filled.PhotoLibrary)
    object Settings : NavScreen("settings", "Configuración", Icons.Filled.Settings)
}
package com.bo.victor.wallapersapp.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

/****
 * Project: WallapersApp
 * From: com.bo.victor.wallapersapp.ui.screens
 * Created by: Victor Sanjines Lopez on 19/3/2025
 * More info: www.victorsanjines.com.bo
 * All rights reserved 2025
 ****/

@Composable
fun HomeScreen(navController: NavHostController) {
    Text(text = "Pantalla de Inicio")
}

@Composable
fun GalleryScreen(navController: NavHostController) {
    Text(text = "Seleccionar imágenes")
}

@Composable
fun SettingsScreen(navController: NavHostController) {
    Text(text = "Configuraciones")
}

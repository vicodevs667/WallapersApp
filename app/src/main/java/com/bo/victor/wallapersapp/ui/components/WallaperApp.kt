package com.bo.victor.wallapersapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.bo.victor.wallapersapp.ui.navigation.BottomNavigationBar
import com.bo.victor.wallapersapp.ui.navigation.NavigationGraph

/****
 * Project: WallapersApp
 * From: com.bo.victor.wallapersapp.ui.components
 * Created by: Victor Sanjines Lopez on 19/3/2025
 * More info: www.victorsanjines.com.bo
 * All rights reserved 2025
 ****/
@Composable
fun WallaperApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        paddingValues -> NavigationGraph(navController, Modifier.padding(paddingValues))
    }
}

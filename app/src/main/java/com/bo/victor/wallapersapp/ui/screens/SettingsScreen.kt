package com.bo.victor.wallapersapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bo.victor.wallapersapp.presentation.viewmodel.WallpaperViewModel

/****
 * Project: WallapersApp
 * From: com.bo.victor.wallapersapp.ui.screens
 * Created by: Victor Sanjines Lopez on 7/4/2025
 * More info: www.victorsanjines.com.bo
 * All rights reserved 2025
 ****/
@Composable
fun SettingsScreen(
    navController: NavHostController,
    viewModel: WallpaperViewModel = hiltViewModel()
) {
    val currentInterval by viewModel.interval.collectAsState()
    var selectedInterval by remember { mutableStateOf(currentInterval) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Intervalo de cambio de fondo (minutos)", style = MaterialTheme.typography.titleMedium)

        Slider(
            value = selectedInterval.toFloat(),
            onValueChange =  { selectedInterval = it.toInt() },
            valueRange = 5f..60f,
            steps = 10
        )

        Text(text = "Seleccionado: $selectedInterval minutos")

        Button(onClick = { viewModel.setInterval(selectedInterval) }) {
            Text(text ="Guardar Intervalo")
        }
    }

}

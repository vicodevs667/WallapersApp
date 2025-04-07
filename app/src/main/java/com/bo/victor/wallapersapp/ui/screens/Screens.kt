package com.bo.victor.wallapersapp.ui.screens

import android.net.Uri
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.bo.victor.wallapersapp.presentation.viewmodel.WallpaperViewModel

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
fun GalleryScreen(navController: NavHostController, wallpaperViewModel: WallpaperViewModel = hiltViewModel()) {
    val selectedImages = remember { derivedStateOf { wallpaperViewModel.selectedImages } }.value

    val imagePickerLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        uri?.let { wallpaperViewModel.addImage(it) }
    }

    val legacyImagePickerLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { wallpaperViewModel.addImage(it) }
    }

    Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                imagePickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            } else {
                legacyImagePickerLauncher.launch("image/*")
            }
        }) {
            Text("Seleccionar Imagen")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(items = selectedImages, key = { it }) { uri ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(uri),
                        contentDescription = "Imagen seleccionada",
                        modifier = Modifier
                            .weight(1f)
                            .height(200.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { wallpaperViewModel.removeImage(uri) }) {
                        Text("X")
                    }
                }

            }
        }
    }
}


@Composable
fun SettingsScreen(navController: NavHostController) {
    Text(text = "Configuraciones")
}

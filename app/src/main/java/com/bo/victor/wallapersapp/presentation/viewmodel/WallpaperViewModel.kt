package com.bo.victor.wallapersapp.presentation.viewmodel

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/****
 * Project: WallapersApp
 * From: com.bo.victor.wallapersapp.presentation.viewmodel
 * Created by: Victor Sanjines Lopez on 20/3/2025
 * More info: www.victorsanjines.com.bo
 * All rights reserved 2025
 ****/
@HiltViewModel
class WallpaperViewModel @Inject constructor() : ViewModel() {
    private val _selectedImages = mutableStateListOf<Uri>()
    val selectedImages: List<Uri> get() = _selectedImages

    fun addImage(uri: Uri) {
        viewModelScope.launch {
            _selectedImages.add(uri)
        }
    }

    fun removeImage(uri: Uri) {
        viewModelScope.launch {
            _selectedImages.remove(uri)
        }
    }
}
package com.bo.victor.wallapersapp.presentation.viewmodel

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bo.victor.wallapersapp.data.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
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
class WallpaperViewModel @Inject constructor(
    private val repository: ImageRepository
) : ViewModel() {
    val selectedImages: StateFlow<List<Uri>> = repository.selectedImages
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addImage(uri: Uri) {
        viewModelScope.launch {
            repository.addImage(uri)
        }
    }

    fun removeImage(uri: Uri) {
        viewModelScope.launch {
            repository.removeImage(uri)
        }
    }
}
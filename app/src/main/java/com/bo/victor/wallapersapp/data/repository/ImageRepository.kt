package com.bo.victor.wallapersapp.data.repository

import android.net.Uri
import com.bo.victor.wallapersapp.data.local.ImageDataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/****
 * Project: WallapersApp
 * From: com.bo.victor.wallapersapp.data.repository
 * Created by: Victor Sanjines Lopez on 7/4/2025
 * More info: www.victorsanjines.com.bo
 * All rights reserved 2025
 ****/
class ImageRepository @Inject constructor(
    private val dataStore: ImageDataStore
) {
    val selectedImages: Flow<List<Uri>> = dataStore.imagesFlow
    val interval: Flow<Int> = dataStore.intervalFlow

    suspend fun addImage(uri: Uri) = dataStore.saveImage(uri)

    suspend fun removeImage(uri: Uri) = dataStore.removeImage(uri)

    suspend fun setInterval(minutes: Int) = dataStore.setInterval(minutes)

}
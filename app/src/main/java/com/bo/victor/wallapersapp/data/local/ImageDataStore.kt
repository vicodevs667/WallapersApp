package com.bo.victor.wallapersapp.data.local

import android.content.Context
import android.net.Uri
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/****
 * Project: WallapersApp
 * From: com.bo.victor.wallapersapp.data.local
 * Created by: Victor Sanjines Lopez on 7/4/2025
 * More info: www.victorsanjines.com.bo
 * All rights reserved 2025
 ****/

private val Context.datastore by preferencesDataStore(name = "image_store")
class ImageDataStore @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val IMAGES_KEY = stringSetPreferencesKey("images_uris")

    val imagesFlow: Flow<List<Uri>> = context.datastore.data
        .map { prefs ->
            prefs[IMAGES_KEY]?.map { Uri.parse(it) } ?: emptyList()
        }

    suspend fun saveImage(uri: Uri) {
        context.datastore.edit { prefs ->
            val current = prefs[IMAGES_KEY]?.toMutableSet() ?: mutableSetOf()
            current.add(uri.toString())
            prefs[IMAGES_KEY] = current
        }
    }

    suspend fun removeImage(uri: Uri) {
        context.datastore.edit { prefs ->
            val current = prefs[IMAGES_KEY]?.toMutableSet() ?: mutableSetOf()
            current.remove(uri.toString())
            prefs[IMAGES_KEY] = current
        }
    }
}
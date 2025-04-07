package com.bo.victor.wallapersapp.work

import android.content.Context
import android.graphics.BitmapFactory
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bo.victor.wallapersapp.data.local.ImageDataStore
import dagger.assisted.AssistedInject
import dagger.assisted.Assisted
import kotlinx.coroutines.flow.first
import java.io.InputStream
import android.app.WallpaperManager

/****
 * Project: WallapersApp
 * From: com.bo.victor.wallapersapp.work
 * Created by: Victor Sanjines Lopez on 7/4/2025
 * More info: www.victorsanjines.com.bo
 * All rights reserved 2025
 ****/
class WallpaperWorker @AssistedInject constructor(
    @Assisted val context: Context,
    @Assisted val workerParams: WorkerParameters,
    private val imageDataStore: ImageDataStore
): CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        val images = imageDataStore.imagesFlow.first()
        if (images.isEmpty()) return Result.success()

        val randomImage = images.random()
        val inputStream: InputStream? = context.contentResolver.openInputStream(randomImage)
        val bitmap = inputStream?.use { BitmapFactory.decodeStream(it) }

        return try {
            bitmap?.let {
                WallpaperManager.getInstance(context).setBitmap(it)
                Result.success()
            } ?: Result.failure()
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure()
        }
    }
}
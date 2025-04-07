package com.bo.victor.wallapersapp.di

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.bo.victor.wallapersapp.data.local.ImageDataStore
import com.bo.victor.wallapersapp.data.repository.ImageRepository
import com.bo.victor.wallapersapp.work.WallpaperWorker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

/****
 * Project: WallapersApp
 * From: com.bo.victor.wallapersapp.di
 * Created by: Victor Sanjines Lopez on 7/4/2025
 * More info: www.victorsanjines.com.bo
 * All rights reserved 2025
 ****/
class WallpaperWorkerFactory @Inject constructor(
    private val imageDataStore: ImageDataStore
): WorkerFactory() {

        override fun createWorker(
            appContext: Context,
            workerClassName: String,
            params: WorkerParameters
        ): WallpaperWorker? {
            return when (workerClassName) {
                WallpaperWorker::class.java.name ->
                    WallpaperWorker(appContext, params, imageDataStore)
                else -> null
            }
        }
}


@Module
@InstallIn(SingletonComponent::class)
object WorkerModule {

    @Provides
    @Singleton
    fun provideWallpaperWorkerFactory(
        imageDataStore: ImageDataStore
    ): WorkerFactory = WallpaperWorkerFactory(imageDataStore)
}
package com.bo.victor.wallapersapp.di

import android.content.Context
import com.bo.victor.wallapersapp.data.local.ImageDataStore
import com.bo.victor.wallapersapp.data.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/****
 * Project: WallapersApp
 * From: com.bo.victor.wallapersapp.di
 * Created by: Victor Sanjines Lopez on 20/3/2025
 * More info: www.victorsanjines.com.bo
 * All rights reserved 2025
 ****/
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideImageDataStore(@ApplicationContext context: Context): ImageDataStore {
        return ImageDataStore(context)
    }

    @Provides
    @Singleton
    fun provideImageRepository(dataStore: ImageDataStore): ImageRepository {
        return ImageRepository(dataStore)
    }
}
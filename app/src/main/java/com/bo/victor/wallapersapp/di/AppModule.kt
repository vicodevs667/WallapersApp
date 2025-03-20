package com.bo.victor.wallapersapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideExampleDependency(): String {
        return "This is an example dependency"
    }
}
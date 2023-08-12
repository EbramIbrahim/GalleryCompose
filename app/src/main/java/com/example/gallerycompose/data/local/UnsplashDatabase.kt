package com.example.gallerycompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gallerycompose.data.model.UnsplashImage
import com.example.gallerycompose.data.model.UnsplashRemoteKeys


@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase:RoomDatabase() {

    abstract fun imageDao(): UnsplashImageDao
    abstract fun remoteKeyDao(): UnsplashRemoteKeysDao
}
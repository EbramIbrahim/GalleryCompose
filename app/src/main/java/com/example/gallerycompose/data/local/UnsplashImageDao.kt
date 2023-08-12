package com.example.gallerycompose.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gallerycompose.data.model.UnsplashImage


@Dao
interface UnsplashImageDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImages(images: List<UnsplashImage>)

    @Query("DELETE FROM unsplash_image_table")
    suspend fun deleteAllImages()

    @Query("SELECT * FROM unsplash_image_table")
    fun getAllImages():PagingSource<Int, UnsplashImage>

}










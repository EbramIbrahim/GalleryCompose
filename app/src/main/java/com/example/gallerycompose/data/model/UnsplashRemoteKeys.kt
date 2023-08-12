package com.example.gallerycompose.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gallerycompose.utils.Constant.UNSPLASH_REMOTE_KEY_TABLE


@Entity(tableName = UNSPLASH_REMOTE_KEY_TABLE)
data class UnsplashRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prevKey: Int?,
    val nextKey: Int?,
)

package com.example.gallerycompose.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gallerycompose.utils.Constant.UNSPLASH_IMAGE_TABLE
import kotlinx.serialization.Serializable


@Serializable
@Entity(tableName = UNSPLASH_IMAGE_TABLE)
data class UnsplashImage(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val likes: Int,
    @Embedded
    val urls: Urls,
    @Embedded
    val user: User,
)







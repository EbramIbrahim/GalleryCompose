package com.example.gallerycompose.presentation.home_screen

import androidx.lifecycle.ViewModel
import com.example.gallerycompose.data.repository.UnsplashImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class UnsplashImageViewModel @Inject constructor(
    private val repository: UnsplashImageRepository
): ViewModel() {

    val getAllImages = repository.getAllImages()
}


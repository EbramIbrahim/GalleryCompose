package com.example.gallerycompose.presentation.search_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.gallerycompose.data.model.UnsplashImage
import com.example.gallerycompose.data.repository.UnsplashImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchImagesViewModel @Inject constructor(
    private val repository: UnsplashImageRepository
): ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery



    private val _searchImages = MutableStateFlow<PagingData<UnsplashImage>>(PagingData.empty())
    val searchImages = _searchImages



    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }


    fun searchImages(query: String) {
        viewModelScope.launch {
            repository.getSearchImages(query).cachedIn(viewModelScope).collect {
                _searchImages.value = it
            }
        }
    }


}















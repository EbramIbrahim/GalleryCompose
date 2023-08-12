package com.example.gallerycompose.presentation.search_screen

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.gallerycompose.presentation.common.ListContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    searchViewModel: SearchImagesViewModel = hiltViewModel(),
    navController: NavController,

) {

    val searchQuery by searchViewModel.searchQuery
    val searchImages = searchViewModel.searchImages.collectAsLazyPagingItems()
    val context = LocalContext.current


    Scaffold(

        topBar = {
            SearchWidget(
                text = searchQuery,
                onTextChange = {
                    searchViewModel.updateSearchQuery(it)
                },
                onSearchClicked = {
                    searchViewModel.searchImages(it)
                },
                onCloseClicked = {
                    navController.popBackStack()
                }
            )
        },
        content = {
            ListContent(items = searchImages, context = context)
        }

    )

}
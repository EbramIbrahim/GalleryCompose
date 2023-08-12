package com.example.gallerycompose.presentation.home_screen

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.gallerycompose.navigation.Screens
import com.example.gallerycompose.presentation.common.ListContent

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    unsplashViewModel: UnsplashImageViewModel = hiltViewModel()
) {

    val unsplashImages = unsplashViewModel.getAllImages.collectAsLazyPagingItems()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            HomeTopBar {
                navController.navigate(Screens.SearchScreen.route) {
                    launchSingleTop = true
                }
            }
        },
        content = {
            ListContent(items = unsplashImages, context = context)
        }
    )





}
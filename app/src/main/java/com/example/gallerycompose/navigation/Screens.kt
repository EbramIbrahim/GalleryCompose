package com.example.gallerycompose.navigation

sealed class Screens(val route: String) {
    object HomeScreen: Screens("home_screen")
    object SearchScreen: Screens("search_screen")
}

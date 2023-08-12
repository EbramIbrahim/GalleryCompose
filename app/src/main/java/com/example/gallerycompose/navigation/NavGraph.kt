package com.example.gallerycompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gallerycompose.presentation.home_screen.HomeScreen
import com.example.gallerycompose.presentation.search_screen.SearchScreen

@Composable
fun SetUpNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ) {

        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screens.SearchScreen.route) {
          SearchScreen(navController = navController)
        }

    }
}







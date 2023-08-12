package com.example.gallerycompose.presentation.home_screen


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.gallerycompose.ui.theme.Purple500


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    onSearchClicked: () -> Unit
) {

    TopAppBar(
        title = {
            Text(
                text = "Home",
                color = Color.White
            )

        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Purple500),
        actions = {
            IconButton(onClick = { onSearchClicked() }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search image",
                    tint = Color.White
                )
            }
        }
    )


}














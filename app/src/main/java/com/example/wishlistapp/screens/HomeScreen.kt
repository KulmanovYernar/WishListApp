package com.example.wishlistapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wishlistapp.R
import com.example.wishlistapp.navigation.ScreenRoute
import com.example.wishlistapp.ui_components.AppBar
import com.example.wishlistapp.ui_components.WishItem
import com.example.wishlistapp.viewmodel.WishViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: WishViewModel
) {
    val context = LocalContext.current
    val wishList = viewModel.allWishes.collectAsState(initial = listOf())


    Scaffold(
        topBar = {
                AppBar(title = stringResource(id = R.string.wish_list))
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(all = 20.dp),
                contentColor = Color.White,
                containerColor = Color.Black,
                onClick = { navController.navigate(ScreenRoute.AddScreenRoute.route) }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(wishList.value) { wish ->
                WishItem(wish = wish) {

                }
            }
        }
    }
}
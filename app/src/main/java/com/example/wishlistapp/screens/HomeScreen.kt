package com.example.wishlistapp.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
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

@OptIn(ExperimentalMaterial3Api::class)
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
                onClick = { navController.navigate(ScreenRoute.AddEditScreenRoute.route + "/0L") }
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
                val dismissState = rememberSwipeToDismissBoxState(
                    confirmValueChange = {
                        if (it == SwipeToDismissBoxValue.StartToEnd || it == SwipeToDismissBoxValue.EndToStart) {
                            viewModel.deleteWish(wish)
                        }
                        true
                    }
                )

                SwipeToDismissBox(
                    state = dismissState, backgroundContent = {
                        val color by animateColorAsState(
                            targetValue = if (dismissState.dismissDirection == SwipeToDismissBoxValue.EndToStart)
                                Color.Red else Color.Transparent,
                            label = "Delete"
                        )

                        Box(
                            Modifier
                                .fillMaxSize()
                                .padding(top = 8.dp)
                                .background(color)
                                .padding(horizontal = 20.dp),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Icon(
                                Icons.Default.Delete,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    },
                    enableDismissFromEndToStart = true,
                    enableDismissFromStartToEnd = false
                ) {
                    WishItem(wish = wish) {
                        navController.navigate(ScreenRoute.AddEditScreenRoute.route + "/${wish.id}")
                    }
                }
            }
        }
    }
}
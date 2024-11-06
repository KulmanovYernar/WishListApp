package com.example.wishlistapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wishlistapp.screens.AddEditDetailScreen
import com.example.wishlistapp.screens.HomeScreen
import com.example.wishlistapp.viewmodel.WishViewModel


@Composable
fun Navigation(
    viewModel: WishViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.HomeScreenRoute.route
    ) {
        composable(route = ScreenRoute.HomeScreenRoute.route) {
            HomeScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(route = ScreenRoute.AddEditScreenRoute.route + "/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.LongType
                    defaultValue = 0L
                    nullable = false
                }
            )
        ) { entry ->
            val id = if(entry.arguments != null) entry.arguments!!.getLong("id") else 0L
            AddEditDetailScreen(
                navController = navController,
                viewModel = viewModel,
                id = id
            )
        }
    }
}
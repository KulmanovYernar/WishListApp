package com.example.wishlistapp.navigation

sealed class ScreenRoute(val route: String) {
    object HomeScreenRoute: ScreenRoute("homeScreen")
    object AddScreenRoute: ScreenRoute("addScreen")
}
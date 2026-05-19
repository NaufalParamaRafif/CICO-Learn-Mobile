package com.example.cicolearn

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.cicolearn.screen.HomeScreen
import com.example.cicolearn.screen.NotificationScreen
import com.example.cicolearn.screen.SearchScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Notification.route) {
            NotificationScreen(navController = navController)
        }
        composable(
            route = Screen.Search.route,
            arguments = listOf(navArgument("placeholderText", {
                type = NavType.StringType
                defaultValue = "Search..."
            })),
        ) {
            SearchScreen(
                navController = navController,
                placeholderText = it.arguments?.getString("placeholderText", "Search...").toString()
            )
        }
    }
}
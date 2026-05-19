package com.example.cicolearn.graphs

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavGraphNavigator
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.cicolearn.BottomBarScreen
import com.example.cicolearn.screen.HomeScreen
import com.example.cicolearn.screen.NotificationScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Memorize.route) {
            Text("Memorize")
        }
        composable(route = BottomBarScreen.TrainWithAI.route) {
            Text("Train with AI")
        }
        composable(route = BottomBarScreen.Profile.route) {
            Text("Profile")
        }
        homeDetailsNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.homeDetailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.HOMEDETAILS,
        startDestination = HomeDetailsScreen.Notification.route
    ) {
        composable(route = HomeDetailsScreen.Notification.route) {
            NotificationScreen(navController = navController)
        }
    }
}

sealed class HomeDetailsScreen(val route: String) {
    object Notification : HomeDetailsScreen(route = "notification")
}

object Graph {
    const val HOME = "home_graph"
    const val HOMEDETAILS = "home_details_graph"
}
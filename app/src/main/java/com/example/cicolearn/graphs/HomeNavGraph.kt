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
import com.example.cicolearn.screen.MemorizeScreen
import com.example.cicolearn.screen.NotificationScreen
import com.example.cicolearn.screen.SearchScreen
import com.example.cicolearn.screen.TrainWithAIScreen

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
            MemorizeScreen(navController)
        }
        composable(route = BottomBarScreen.TrainWithAI.route) {
            TrainWithAIScreen(navController)
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
        composable(route = HomeDetailsScreen.Search.route) {
            SearchScreen(navController = navController)
        }
    }
}

sealed class HomeDetailsScreen(val route: String) {
    object Notification : HomeDetailsScreen(route = "notification")
    object Search : HomeDetailsScreen(route = "search")
}

object Graph {
    const val HOME = "home_graph"
    const val HOMEDETAILS = "home_details_graph"
}
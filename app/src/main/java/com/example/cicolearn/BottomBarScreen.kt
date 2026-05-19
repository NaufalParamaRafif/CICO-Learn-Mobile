package com.example.cicolearn

import androidx.annotation.DrawableRes
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlin.collections.contains

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    @param:DrawableRes val selectedIcon: Int,
    @param:DrawableRes val unselectedIcon: Int,
) {
//    val tabBarItems = listOf<TabBarItem>(homepageTab, memorizeTab, trainWithAITab, profileTab)
//
//    val navController = rememberNavController()
//    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
//
//    val showBottomBar = currentRoute in listOf(
//        "Home", "Memorize", "Train with AI", "Profile", "Notification"
//    )

    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        selectedIcon = R.drawable.ic_bottom_app_bar_selected_homepage,
        unselectedIcon = R.drawable.ic_bottom_app_bar_unselected_homepage
    )
    object Memorize : BottomBarScreen(
        route = "memorize",
        title = "Memorize",
        selectedIcon = R.drawable.ic_bottom_app_bar_selected_memorize,
        unselectedIcon = R.drawable.ic_bottom_app_bar_unselected_memorize
    )
    object TrainWithAI : BottomBarScreen(
        route = "train_with_ai",
        title = "Train with AI",
        selectedIcon = R.drawable.ic_bottom_app_bar_selected_train_with_ai,
        unselectedIcon = R.drawable.ic_bottom_app_bar_unselected_memorize
    )
    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        selectedIcon = R.drawable.ic_bottom_app_bar_selected_profile,
        unselectedIcon = R.drawable.ic_bottom_app_bar_unselected_profile
    )

}
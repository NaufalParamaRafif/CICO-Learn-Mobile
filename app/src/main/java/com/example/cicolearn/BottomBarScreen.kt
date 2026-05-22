package com.example.cicolearn

import androidx.annotation.DrawableRes

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    @param:DrawableRes val selectedIcon: Int,
    @param:DrawableRes val unselectedIcon: Int,
) {
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

val bottomNavScreenList = listOf(
    BottomBarScreen.Home,
    BottomBarScreen.Memorize,
    BottomBarScreen.TrainWithAI,
    BottomBarScreen.Profile
)

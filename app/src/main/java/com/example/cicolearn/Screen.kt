package com.example.cicolearn

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Notification: Screen(route = "notification_screen")
    object Search: Screen( route = "search_screen?placeholderText={placeholderText}" ) {
        fun passPlaceholderText(placeholderText: String = "Search"): String {
            return "search_screen?placeholderText=$placeholderText"
        }
    }

}
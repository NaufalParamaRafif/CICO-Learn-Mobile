package com.example.cicolearn.components

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cicolearn.BottomBarScreen
import com.example.cicolearn.TabBarItem
import com.example.cicolearn.ui.theme.LightBottomNavigationLightText
import com.example.cicolearn.ui.theme.LightDarkText

@Composable
fun TabView(navController: NavController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Memorize,
        BottomBarScreen.TrainWithAI,
        BottomBarScreen.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    NavigationBar {
        if (bottomBarDestination) {
            screens.forEachIndexed { index,screen ->
                val selected = currentDestination?.hierarchy?.any {
                    it.route == screen.route
                } == true
                NavigationBarItem(
                    selected = selected,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.id)
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        TabBarIconView(
                            isSelected = selected,
                            selectedIcon = screen.selectedIcon,
                            unselectedIcon = screen.unselectedIcon,
                            title = screen.title
                        )
                    },
                    label = {
                        Text(
                            text = screen.title,
                            color = if (selected) { LightDarkText } else { LightBottomNavigationLightText }
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.Transparent,
                        unselectedIconColor = Color.Transparent,
                        indicatorColor = Color.Transparent,
                        selectedTextColor = LightDarkText,
                        unselectedTextColor = LightBottomNavigationLightText
                    ),
                )
            }
        }
    }
}

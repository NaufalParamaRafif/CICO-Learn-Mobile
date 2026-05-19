package com.example.cicolearn

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.components.TabView
import com.example.cicolearn.graphs.HomeNavGraph
import com.example.cicolearn.screen.HomeScreen
import com.example.cicolearn.screen.NotificationScreen
import com.example.cicolearn.screen.SearchScreen
import com.example.cicolearn.ui.theme.CICOLearnTheme
import com.example.cicolearn.ui.theme.LightBackground

data class TabBarItem(
    val title: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
)

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            val homepageTab = TabBarItem(title = "Home", selectedIcon = R.drawable.ic_bottom_app_bar_selected_homepage, unselectedIcon = R.drawable.ic_bottom_app_bar_unselected_homepage)
//            val memorizeTab = TabBarItem(title = "Memorize", selectedIcon = R.drawable.ic_bottom_app_bar_selected_memorize, unselectedIcon = R.drawable.ic_bottom_app_bar_unselected_memorize)
//            val trainWithAITab = TabBarItem(title = "Train with AI", selectedIcon = R.drawable.ic_bottom_app_bar_selected_train_with_ai, unselectedIcon = R.drawable.ic_bottom_app_bar_unselected_memorize)
//            val profileTab = TabBarItem(title = "Profile", selectedIcon = R.drawable.ic_bottom_app_bar_selected_profile, unselectedIcon = R.drawable.ic_bottom_app_bar_unselected_profile)
//
//            val tabBarItems = listOf<TabBarItem>(homepageTab, memorizeTab, trainWithAITab, profileTab)
//
            val navController = rememberNavController()
//            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
//
//            val showBottomBar = currentRoute in listOf(
//                "Home", "Memorize", "Train with AI", "Profile", "Notification"
//            )

            CICOLearnTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = LightBackground
                ) {
                    Scaffold(
                        bottomBar = {
//                            if (showBottomBar) {
//                                TabView(navController)
//                            }
                            TabView(navController = navController)
                        }
                    ) {
                        HomeNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}












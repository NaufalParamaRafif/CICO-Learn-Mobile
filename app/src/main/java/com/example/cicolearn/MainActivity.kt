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
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.components.TabView
import com.example.cicolearn.graphs.HomeNavGraph
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
            val navController = rememberNavController()
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
            val showBottomBar = bottomNavScreenList.any { it.route == currentRoute }

            CICOLearnTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = LightBackground
                ) {
                    Scaffold(
                        bottomBar = {
                            if (showBottomBar) {
                                TabView(navController = navController)
                            }
                        }
                    ) {
                        HomeNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}












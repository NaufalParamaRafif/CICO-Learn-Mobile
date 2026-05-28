package com.example.cicolearn.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.components.MemorizeHistoryItem
import com.example.cicolearn.components.TopAppBarBack
import com.example.cicolearn.ui.theme.LightBackground

@Composable
fun MemorizeHistoryScreen(navController: NavController) {
    Scaffold(
        containerColor = LightBackground,
        topBar = {
            TopAppBarBack(
                navController,
                "Memorize History"
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding).padding(horizontal = 24.dp)
        ) {
            MemorizeHistoryItem("Introduction at Office", 499, "1 hour ago", 3, 4)
            Spacer(Modifier.height(8.dp))
            MemorizeHistoryItem("Introduction at Minimarket", 54, "9 hour ago", 5, 9)
        }
    }
}

@Preview
@Composable
private fun MemorizeHistoryScreenPreview() {
    val navController = rememberNavController()
    MemorizeHistoryScreen(navController)
}
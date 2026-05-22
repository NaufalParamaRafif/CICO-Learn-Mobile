package com.example.cicolearn.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.components.TopAppBarBack
import com.example.cicolearn.components.TrainWithAIHistoryItem
import com.example.cicolearn.ui.theme.LightBackground

@Composable
fun TrainWithAIHistoryScreen(navController: NavController) {
    Scaffold(
        containerColor = LightBackground,
        topBar = {
            TopAppBarBack(navController, "Train with AI History")
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding)
        ) {
            TrainWithAIHistoryItem("Free Talk", "15 Minutes", "2 hour ago")
            TrainWithAIHistoryItem("Introduction to Stranger", "15 Minutes", "4 hour ago", "Introduction")
            TrainWithAIHistoryItem("Free Talk", "15 Minutes", "9 hour ago")
        }
    }
}

@Preview
@Composable
private fun TrainWithAIHistoryScreenPreview() {
    val navController = rememberNavController()
    TrainWithAIHistoryScreen(navController)
}
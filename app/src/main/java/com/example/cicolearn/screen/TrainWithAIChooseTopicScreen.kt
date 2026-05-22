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
import com.example.cicolearn.components.TrainWithAITopicItem
import com.example.cicolearn.ui.theme.LightBackground

@Composable
fun TrainWithAIChooseTopicScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBarBack(
                navController,
                "Choose Topic!"
            )
        },
        containerColor = LightBackground
    ) { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding)
        ) {
            TrainWithAITopicItem("Ticket to Ride", "Scenario: A taxi driver who loves to ask their passenger questions but doesn’t watch the road.")
        }
    }
}

@Preview
@Composable
private fun TrainWithAIChooseTopicScreenPreview() {
    val navController = rememberNavController()
    TrainWithAIChooseTopicScreen(navController)
}
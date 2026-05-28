package com.example.cicolearn.screen

import androidx.collection.ArrayMap
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.components.LessonProgressIndicator
import com.example.cicolearn.components.LessonProgressIndicatorUnit
import com.example.cicolearn.components.SystemDialogCard
import com.example.cicolearn.components.TrainWithAIRolePlayTopAppBar
import com.example.cicolearn.components.TrainWithAIRulesPopup
import com.example.cicolearn.ui.theme.LightBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainWithAIRolePlayScreen(navController: NavController) {
    val ruleAndCaption = ArrayMap<String, String>()
    ruleAndCaption["Your task: "] = "Choose a scientific concept and explain it as clearly as possible. Imagine you are teaching someone who has basic curiosity but little technical knowledge."
    ruleAndCaption["Focus on clarity: "] = "Break the idea into simple steps so the listener can follow your reasoning."
    ruleAndCaption["Use examples: "] = "Real-life examples or analogies are encouraged to make the concept easier to understand.\\n" + "Structure your explanation: Start with the main idea, then explain how it works, and finish with why it matters."
    ruleAndCaption["Goal: "] = "By the end, the listener should understand the concept and why it is interesting or useful."

    Scaffold(
        containerColor = LightBackground,
        topBar = {
            TrainWithAIRolePlayTopAppBar(navController, "Role Play", "Ticket to Ride")
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                LessonProgressIndicator(21, 78, LessonProgressIndicatorUnit.DIALOG)

                Spacer(Modifier.height(16.dp))

                SystemDialogCard("So it's a tool to be used to develop and enhance what you do!")
            }

            Box(
                modifier = Modifier
                    .background(Color.Black.copy(0.54f))
                    .fillMaxSize()
                    .padding(horizontal = 32.dp),
                contentAlignment = Alignment.Center
            ) {
                // TODO: Use this commented elemment 
//                TrainWithAIContextBackgroundPopup("Role Play Rules", "You are at a train station ticket counter and need to buy a ticket to another city. Speak clearly and politely with the ticket officer. Ask about the destination, departure time, ticket price, and available seats. You may also ask follow-up questions if something is unclear. Keep your sentences natural and conversational. Do not give one-word answers, and avoid switching to another language. Try to complete the purchase by confirming the ticket details and thanking the officer at the end.","OK")
                TrainWithAIRulesPopup("Role Play Rules", "OK", ruleAndCaption)
            }
        }
    }
}

@Preview
@Composable
private fun TrainWithAIRolePlayScreenPreview() {
    val navController = rememberNavController()
    TrainWithAIRolePlayScreen(navController)
}
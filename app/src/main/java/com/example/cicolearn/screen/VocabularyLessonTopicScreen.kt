package com.example.cicolearn.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.components.LearnVocabularyLessonDraftItem
import com.example.cicolearn.components.LearnVocabularyLessonTopicWordItem
import com.example.cicolearn.components.PrimaryGradientElevatedButton
import com.example.cicolearn.components.TopAppBarBack
import com.example.cicolearn.components.VocabularyLessonTopicCaption
import com.example.cicolearn.components.VocabularyLessonTopicSearch
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient
import com.example.cicolearn.ui.theme.LightSurface

@Composable
fun VocabularyLessonTopicScreen(navController: NavController) {
    Scaffold(
        containerColor = LightBackground,
        topBar = {
            TopAppBarBack(
                navController,
                "Learn Vocabulary"
            )
        },
        floatingActionButton = {
            PrimaryGradientElevatedButton("Start Learning")
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { contentPadding ->
        Box(

        ) {
            Column(
                modifier = Modifier.padding(contentPadding).padding(horizontal = 24.dp)
            ) {
                VocabularyLessonTopicCaption("Topic: Foods and Beverage", "This is most common foods and beverage for a lot of native speaker")

                Spacer(Modifier.height(24.dp))

                VocabularyLessonTopicSearch()

                Spacer(Modifier.height(16.dp))

                Column(
                    modifier = Modifier.background(LightSurface)
                        .border(width = 0.8.dp, color = LightLightBorder, shape = RoundedCornerShape(8.dp))
                ) {
                    LearnVocabularyLessonTopicWordItem("Milk", "Meaning: White liquid produced by mammals")
                    LearnVocabularyLessonTopicWordItem("Milk", "Meaning: White liquid produced by mammals Meaning: White liquid produced by mammals Meaning: White liquid produced by mammals")
                }
            }
            Column(
                modifier = Modifier.fillMaxSize().background(Color(0xFF667799).copy(alpha = 0.5f)).padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .background(LightSurface, RoundedCornerShape(8.dp))
                        .border(0.8.dp, LightDarkBorder, RoundedCornerShape(8.dp))
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 0.dp)
                ) {
                    VocabularyLessonTopicSearch()

                    LearnVocabularyLessonDraftItem("IELTS Words")
                    HorizontalDivider(thickness = 0.8.dp, color = LightLightBorder)
                }

                Spacer(Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .background(LightPrimaryGradient, RoundedCornerShape(4.dp))
                        .fillMaxWidth().padding(vertical = 12.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("Save", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = LightOnPrimary)
                }
            }
        }
    }
}

@Preview
@Composable
private fun LearnVocabularyLessonTopicScreenPreview() {
    val navController = rememberNavController()
    VocabularyLessonTopicScreen(navController)
}
package com.example.cicolearn.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.components.BottomMicAndSpeakerComponent
import com.example.cicolearn.components.LessonSpeakAccuracyFeedback
import com.example.cicolearn.components.TopAppBarBack
import com.example.cicolearn.components.VocabularyLessonSpeakSentenceCard
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkText

@Composable
fun VocabularyLessonSpeakSentenceScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBarBack(navController, "Learn Vocabulary")
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            // TODO: Use this commented element 
            BottomMicAndSpeakerComponent()

            LessonSpeakAccuracyFeedback(85, "Jadi, ini adalah alat yang digunakan untuk mengembangkan dan meningkatkan apa yang anda lakukan.")
        },
        containerColor = LightBackground
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Speak this sentence!", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = LightDarkText)
            Spacer(Modifier.height(8.dp))
            VocabularyLessonSpeakSentenceCard("So it's a tool to be used to develop and enhance what you do.", "enhance")
        }
    }
}

@Preview
@Composable
private fun VocabularyLessonSpeakSentenceScreenPreview() {
    val navController = rememberNavController()
    VocabularyLessonSpeakSentenceScreen(navController)
}
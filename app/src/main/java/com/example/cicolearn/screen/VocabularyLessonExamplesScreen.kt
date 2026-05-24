package com.example.cicolearn.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import com.example.cicolearn.components.PrimaryGradientElevatedButton
import com.example.cicolearn.components.TopAppBarBack
import com.example.cicolearn.components.VocabularyLessonExampleItem
import com.example.cicolearn.components.VocabularyLessonWordDefinitionCard
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkText

@Composable
fun VocabularyLessonExamplesScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBarBack(navController, "Learn Vocabulary")
        },
        containerColor = LightBackground,
        floatingActionButton = {
            PrimaryGradientElevatedButton("Next")
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding).padding(horizontal = 24.dp),
        ) {
            VocabularyLessonWordDefinitionCard(word = "Enhance", meaning = "to make it better, improve its quality or increase its value and strengh.", synonyms = "improve, boots, better, increase.", phoneticTranscriptionUS = "/ɪnˈhɑːns/", phoneticTranscriptionUK = "/ɪnˈhɑːns/")

            Spacer(Modifier.height(16.dp))

            Text("Examples:", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = LightDarkText)

            Spacer(Modifier.height(16.dp))

            Column {
                VocabularyLessonExampleItem("It's things like this that enhance the quality of life", "Hal seperti ini yang dapat memperbaiki kualitas hidup")
            }

        }
    }
}

@Preview
@Composable
fun VocabularyLessonExamplesScreenPreview() {
    val navController = rememberNavController()
    VocabularyLessonExamplesScreen(navController)
}
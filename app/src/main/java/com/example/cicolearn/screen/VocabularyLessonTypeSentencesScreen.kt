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
import com.example.cicolearn.components.TextFieldWithCharacterCounter
import com.example.cicolearn.components.TopAppBarBack
import com.example.cicolearn.components.VocabularyLessonWordDefinitionCard
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkText

@Composable
fun VocabularyLessonTypeSentencesScreen(navController: NavController) {
    Scaffold(
        containerColor = LightBackground,
        topBar = {
            TopAppBarBack(navController, "Learn Vocabulary")
        },
        floatingActionButton = {
            PrimaryGradientElevatedButton("Check")
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding).padding(horizontal = 24.dp)
        ) {
            VocabularyLessonWordDefinitionCard(word = "Enhance", meaning = "to make it better, improve its quality or increase its value and strengh.", synonyms = "improve, boots, better, increase.", phoneticTranscriptionUS = "/ɪnˈhɑːns/", phoneticTranscriptionUK = "/ɪnˈhɑːns/")

            Spacer(Modifier.height(16.dp))

            Text("Type 3 sentences that contains \"Enhance\" word!", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = LightDarkText)

            Spacer(Modifier.height(8.dp))

            TextFieldWithCharacterCounter(100)
            Spacer(Modifier.height(12.dp))
            TextFieldWithCharacterCounter(100)
            Spacer(Modifier.height(12.dp))
            TextFieldWithCharacterCounter(100)
        }
    }
}

@Preview
@Composable
private fun VocabularyLessonTypeSentencesScreenPreview() {
    val navController = rememberNavController()
    VocabularyLessonTypeSentencesScreen(navController)
}
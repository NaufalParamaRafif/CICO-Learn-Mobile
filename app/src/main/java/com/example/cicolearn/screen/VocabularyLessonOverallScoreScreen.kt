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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.components.PrimaryGradientElevatedButton
import com.example.cicolearn.components.TopAppBarBack
import com.example.cicolearn.components.VocabularyLessonWordDefinitionCard
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightSuccess

@Composable
fun VocabularyLessonOverallScoreScreen(navController: NavController) {
    Scaffold(
        containerColor = LightBackground,
        topBar = {
            TopAppBarBack( navController, "Learn Vocabulary" )
        },
        floatingActionButton = {
            PrimaryGradientElevatedButton("Next Word")
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                buildAnnotatedString {
                    append("Overall Score for this word: ")

                    withStyle(style = SpanStyle(color = LightSuccess)) {
                        append("85%")
                    }
                }, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = LightDarkText
            )
//            TODO: Add more detail for the score
            Spacer(Modifier.height(8.dp))
            VocabularyLessonWordDefinitionCard(word = "Enhance", meaning = "to make it better, improve its quality or increase its value and strengh.", synonyms = "improve, boots, better, increase.", phoneticTranscriptionUS = "/ɪnˈhɑːns/", phoneticTranscriptionUK = "/ɪnˈhɑːns/")
        }
    }
}

@Preview
@Composable
private fun VocabularyLessonOverallScoreScreenPreview() {
    val navController = rememberNavController()
    VocabularyLessonOverallScoreScreen(navController)
}
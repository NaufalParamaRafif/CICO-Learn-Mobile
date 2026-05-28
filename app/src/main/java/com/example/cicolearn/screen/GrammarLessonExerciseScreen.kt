package com.example.cicolearn.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.components.GrammarLessonExerciseChoice
import com.example.cicolearn.components.GrammarLessonExerciseQuestion
import com.example.cicolearn.components.LessonProgressIndicator
import com.example.cicolearn.components.LessonProgressIndicatorUnit
import com.example.cicolearn.components.PrimaryGradientElevatedButton
import com.example.cicolearn.components.TopAppBarBack
import com.example.cicolearn.ui.theme.LightBackground

@Composable
fun GrammarLessonExerciseScreen(navController: NavController) {
    Scaffold(
        containerColor = LightBackground,
        topBar = {
            TopAppBarBack(
                navController,
                "Learn Grammar"
            )
        },
        floatingActionButton = {
            PrimaryGradientElevatedButton("Check")
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding).padding(horizontal = 24.dp)
        ) {
            LessonProgressIndicator(1, 34, LessonProgressIndicatorUnit.QUESTION)

            Spacer(Modifier.height(20.dp))

            GrammarLessonExerciseQuestion("What is Pronoun?")

            Spacer(Modifier.height(16.dp))

            GrammarLessonExerciseChoice("A", "Pronoun is a pronoun")
            Spacer(Modifier.height(8.dp))
            GrammarLessonExerciseChoice("B", "Pronoun is a pronoun")
            Spacer(Modifier.height(8.dp))
            GrammarLessonExerciseChoice("C", "Pronoun is a pronoun")
            Spacer(Modifier.height(8.dp))
            GrammarLessonExerciseChoice("D", "Pronoun is a pronoun")
        }
    }
}

@Preview
@Composable
private fun GrammarLessonExerciseScreenPreview() {
    val navController = rememberNavController()
    GrammarLessonExerciseScreen(navController)
}
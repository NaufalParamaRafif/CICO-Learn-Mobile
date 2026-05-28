package com.example.cicolearn.screen

import android.util.ArrayMap
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.components.GrammarLessonDefinitonCard
import com.example.cicolearn.components.GrammarLessonExplanationSection
import com.example.cicolearn.components.GrammarLessonProgressIndicator
import com.example.cicolearn.components.TopAppBarBack
import com.example.cicolearn.ui.theme.LightBackground

@Composable
fun GrammarLessonLessonScreen(navController: NavController) {
    val sectionTitles = listOf<String>("Introduction to Nouns", "Type of Nouns", "History of Nouns")
    val headerExplanations = ArrayMap<String, String>()

    headerExplanations["Pengertian Pronoun (What is Pronoun?)"] = "Pronoun adalah kata yang digunakan untuk mengganti noun. Dalam hal ini, noun bisa jadi seseorang, suatu benda, tempat, bahkan tindakan atau gagasan. Yap, benda tersebut bisa jadi benda mati atau benda hidup."

    Scaffold(
        containerColor = LightBackground,
        topBar = {
            TopAppBarBack(navController, "Learn Grammar")
        },
    ) { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding).padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GrammarLessonProgressIndicator(10, sectionTitles, 0)

            Spacer(Modifier.height(16.dp))

            GrammarLessonDefinitonCard("Nouns", "a word used to identify any of a class of people, places, or things, or to name a particular one of these.")

            Spacer(Modifier.height(16.dp))

            GrammarLessonExplanationSection("Introduction to Nouns", 1, true, headerExplanations)
        }
    }
}

@Preview
@Composable
private fun GrammarLessonLessonScreenPreview() {
    val navController = rememberNavController()
    GrammarLessonLessonScreen(navController)
}
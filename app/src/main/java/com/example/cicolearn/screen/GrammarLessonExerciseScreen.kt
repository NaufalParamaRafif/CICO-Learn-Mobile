package com.example.cicolearn.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightLightText
import com.example.cicolearn.ui.theme.LightPrimary
import com.example.cicolearn.ui.theme.LightSurface

// TODO: REFACTOR THIS SCREEN
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
            Column(
                modifier = Modifier
                    .background(LightSurface, RoundedCornerShape(8.dp))
                    .border(0.8.dp, LightLightBorder, RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Progress", fontSize = 10.sp, fontWeight = FontWeight.Medium, color = LightLightText)
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("1/34 ")
                            }
                            append("question")
                        },
                        fontSize = 10.sp, fontWeight = FontWeight.Medium, color = LightLightText
                    )
                }

                Spacer(Modifier.height(8.dp))

                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth(),
                    progress = {0.3f},
                    color = LightPrimary,
                    trackColor = LightLightBorder,
                    drawStopIndicator = {}
                )
            }

            Spacer(Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .background(LightSurface, RoundedCornerShape(8.dp))
                    .border(0.8.dp, LightLightBorder, RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Choose correct answer!", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = LightDarkText)
                Spacer(Modifier.height(8.dp))
                Text("What is Pronoun?", fontSize = 12.sp, color = LightDarkText)
            }

            Spacer(Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .background(LightSurface, RoundedCornerShape(8.dp))
                    .border(0.8.dp, LightLightBorder, RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("A", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = LightDarkText)
                Spacer(Modifier.width(12.dp))
                Text("Pronoun is a pronoun", fontSize = 12.sp, color = LightDarkText, modifier = Modifier.weight(1f))
            }
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .background(LightSurface, RoundedCornerShape(8.dp))
                    .border(0.8.dp, LightLightBorder, RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("A", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = LightDarkText)
                Spacer(Modifier.width(12.dp))
                Text("Pronoun is a pronoun", fontSize = 12.sp, color = LightDarkText, modifier = Modifier.weight(1f))
            }
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .background(LightSurface, RoundedCornerShape(8.dp))
                    .border(0.8.dp, LightLightBorder, RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("A", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = LightDarkText)
                Spacer(Modifier.width(12.dp))
                Text("Pronoun is a pronoun", fontSize = 12.sp, color = LightDarkText, modifier = Modifier.weight(1f))
            }
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .background(LightSurface, RoundedCornerShape(8.dp))
                    .border(0.8.dp, LightLightBorder, RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("A", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = LightDarkText)
                Spacer(Modifier.width(12.dp))
                Text("Pronoun is a pronoun", fontSize = 12.sp, color = LightDarkText, modifier = Modifier.weight(1f))
            }
        }
    }
}

@Preview
@Composable
private fun GrammarLessonExerciseScreenPreview() {
    val navController = rememberNavController()
    GrammarLessonExerciseScreen(navController)
}
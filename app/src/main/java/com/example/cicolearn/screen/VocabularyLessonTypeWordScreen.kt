package com.example.cicolearn.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.R
import com.example.cicolearn.components.PrimaryGradientElevatedButton
import com.example.cicolearn.components.TopAppBarBack
import com.example.cicolearn.components.VocabularyLessonWordDefinitionCard
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDanger
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBackground
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient
import com.example.cicolearn.ui.theme.LightSuccess
import com.example.cicolearn.ui.theme.LightSurface

@Composable
fun VocabularyLessonTypeWordScreen(navController: NavController) {
    Scaffold(
        containerColor = LightBackground,
        topBar = {
            TopAppBarBack(navController, "Learn Vocabulary")
        },
        floatingActionButton = {
            Column(
                modifier = Modifier
                    .background(LightSurface)
                    .fillMaxWidth()
                    .border(1.dp, LightDarkBorder)
                    .padding(bottom = 16.dp)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(R.drawable.ic_color_filled_correct), tint = LightSuccess,contentDescription = null)

                    Spacer(Modifier.width(8.dp))

                    Text("Correct", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = LightDarkText, modifier = Modifier.weight(1f))

                    Spacer(Modifier.width(8.dp))

                    Icon(painter = painterResource(R.drawable.ic_color_filled_report), tint = LightDanger, contentDescription = null)
                }

                PrimaryGradientElevatedButton("Next")
            }

//            PrimaryGradientElevatedButton("Check")
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(horizontal = 24.dp)
        ) {
            VocabularyLessonWordDefinitionCard(word = "Enhance", meaning = "to make it better, improve its quality or increase its value and strengh.", synonyms = "improve, boots, better, increase.", phoneticTranscriptionUS = "/ɪnˈhɑːns/", phoneticTranscriptionUK = "/ɪnˈhɑːns/")

            Spacer(Modifier.height(16.dp))

            Text("Type that word!", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = LightDarkText)

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                modifier = Modifier.background(LightLightBackground).fillMaxWidth().height(44.dp).border(0.8.dp, LightDarkBorder, RoundedCornerShape(4.dp)),
                state = TextFieldState(),
                placeholder = {
                    Text("Type Here", fontSize = 14.sp,  color = LightDarkText.copy(0.35f), fontWeight = FontWeight.Medium)
                },
                lineLimits = TextFieldLineLimits.SingleLine,
                contentPadding = PaddingValues(start = 16.dp),
                textStyle = TextStyle(
                    color = LightDarkText,
                    fontSize = 14.sp,
                ),

            )
        }
    }
}

@Preview
@Composable
private fun VocabularyLessonTypeWordScreenPreview() {
    val navController = rememberNavController()
    VocabularyLessonTypeWordScreen(navController)
}
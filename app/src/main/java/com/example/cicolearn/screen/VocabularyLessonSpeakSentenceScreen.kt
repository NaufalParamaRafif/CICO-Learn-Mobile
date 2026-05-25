package com.example.cicolearn.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.R
import com.example.cicolearn.components.PrimaryGradientElevatedButton
import com.example.cicolearn.components.TopAppBarBack
import com.example.cicolearn.components.VocabularyLessonSpeakSentenceCard
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDanger
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient
import com.example.cicolearn.ui.theme.LightSecondary
import com.example.cicolearn.ui.theme.LightSuccess
import com.example.cicolearn.ui.theme.LightSurface

@Composable
fun VocabularyLessonSpeakSentenceScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBarBack(navController, "Learn Vocabulary")
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
//            Row (
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                IconButton (
//                    onClick = {},
//                    modifier = Modifier
//                        .background(LightSecondary, CircleShape)
//                        .border(0.8.dp, LightDarkBorder, CircleShape)
//                        .size(56.dp)
//                        .aspectRatio(1f)
//                ) {
//                    Box(
//                        contentAlignment = Alignment.Center,
//                        modifier = Modifier.size(40.dp)
//                    ) {
//                        Icon(
//                            painter = painterResource(R.drawable.ic_pronounciation_sound),
//                            contentDescription = null
//                        )
//                        Text("0.75x", fontSize = 8.sp, modifier = Modifier.align(Alignment.BottomEnd))
//                    }
//                }
//
//                Spacer(Modifier.width(24.dp))
//
//                IconButton (
//                    onClick = {},
//                    modifier = Modifier
//                        .background(LightPrimaryGradient, CircleShape)
//                        .size(64.dp)
//                        .aspectRatio(1f)
//                ) {
//                    Icon(
//                        painter = painterResource(R.drawable.ic_mic_speak),
//                        contentDescription = null,
//                        tint = LightOnPrimary
//                    )
//                }
//
//                Spacer(Modifier.width(24.dp))
//
//                IconButton (
//                    onClick = {},
//                    modifier = Modifier
//                        .background(LightSecondary, CircleShape)
//                        .border(0.8.dp, LightDarkBorder, CircleShape)
//                        .size(56.dp)
//                        .aspectRatio(1f)
//                ) {
//                    Icon(
//                        painter = painterResource(R.drawable.ic_pronounciation_sound),
//                        contentDescription = null
//                    )
//                }
//            }

            Column(
                modifier = Modifier
                    .background(LightSurface)
                    .fillMaxWidth()
                    .border(1.dp, LightDarkBorder)
                    .padding(bottom = 16.dp)
            ) {
                Spacer(Modifier.height(12.dp))

                Row(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("85%", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = LightSuccess)

                    Spacer(Modifier.width(8.dp))

                    Text("Accuracy", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = LightDarkText, modifier = Modifier.weight(1f))

                    Spacer(Modifier.width(8.dp))

                    Icon(painter = painterResource(R.drawable.ic_color_filled_report), tint = LightDanger, contentDescription = null)
                }

                Spacer(Modifier.height(12.dp))

                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Artinya: ")
                        }
                        append("Jadi, ini adalah alat yang digunakan untuk mengembangkan dan meningkatkan apa yang anda lakukan.")
                    },
                    fontSize = 12.sp,
                    color = LightDarkText,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                Spacer(Modifier.height(12.dp))

                PrimaryGradientElevatedButton("Next")
            }
        },
        containerColor = LightBackground
    ) { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding).fillMaxSize().padding(horizontal = 24.dp),
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
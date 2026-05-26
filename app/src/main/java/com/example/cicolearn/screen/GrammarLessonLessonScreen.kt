package com.example.cicolearn.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.components.TopAppBarBack
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightLightText
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient
import com.example.cicolearn.ui.theme.LightSecondary
import com.example.cicolearn.ui.theme.LightSurface

// TODO: REFACTOR THIS SCREEN
@Composable
fun GrammarLessonLessonScreen(navController: NavController) {
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
            Column(
                modifier = Modifier
                    .background(LightSurface, RoundedCornerShape(8.dp))
                    .border(0.8.dp, LightLightBorder, RoundedCornerShape(8.dp))
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .scrollable(rememberScrollState(), Orientation.Horizontal),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .background(LightPrimaryGradient, RoundedCornerShape(4.dp))
                            .height(48.dp)
                            .widthIn(max = 280.dp)
                            .padding(horizontal = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                                    append("Section 1: ")
                                }
                                append("Pronoun Function with example Pronoun Function with example with example")
                            },
                            fontSize = 12.sp,
                            color = LightOnPrimary
                        )
                    }

                    Spacer(Modifier.width(8.dp))

                    Box(
                        modifier = Modifier
                            .background(LightSecondary, RoundedCornerShape(4.dp))
                            .border(0.8.dp, LightDarkBorder, RoundedCornerShape(4.dp))
                            .height(48.dp)
                            .widthIn(max = 280.dp)
                            .padding(horizontal = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("Section 2: ")
                                }
                                append("Pronoun Function with example Pronoun Function with example halo hahahah")
                            },
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = LightDarkText
                        )
                    }

                    Spacer(Modifier.width(12.dp))

                }

                Spacer(Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Progress", fontSize = 10.sp, fontWeight = FontWeight.Medium, color = LightLightText)
                    Text("3%", fontSize = 10.sp, fontWeight = FontWeight.Medium, color = LightLightText)
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

            Spacer(Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .background(LightPrimaryGradient, RoundedCornerShape(8.dp))
                    .padding(24.dp)
            ) {
                Text("Nouns", fontSize = 24.sp, color = LightOnPrimary, fontWeight = FontWeight.Bold)

                Spacer(Modifier.height(12.dp))

                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                            append("Meaning: ")
                        }
                        append("a word used to identify any of a class of people, places, or things, or to name a particular one of these.")
                    },
                    fontSize = 14.sp,
                    color = LightOnPrimary,
                )
            }

            Spacer(Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .background(LightSurface, RoundedCornerShape(8.dp))
                    .border(0.8.dp, LightDarkBorder, RoundedCornerShape(8.dp))
            ) {
                Box(
                    modifier = Modifier
                        .background(LightPrimaryGradient, RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 24.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                                append("Section 1: ")
                            }
                            append("Introduction to Nouns")
                        },
                        fontSize = 14.sp,
                        color = LightOnPrimary,
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                ) {
                    Text("Pengertian Pronoun (What is Pronoun?)", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = LightDarkText)
                    Spacer(Modifier.height(8.dp))
                    Text("Pronoun adalah kata yang digunakan untuk mengganti noun. Dalam hal ini, noun bisa jadi seseorang, suatu benda, tempat, bahkan tindakan atau gagasan. Yap, benda tersebut bisa jadi benda mati atau benda hidup.", fontSize = 12.sp, color = LightDarkText)
                    Spacer(Modifier.height(16.dp))
                    Text("Pengertian Pronoun (What is Pronoun?)", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = LightDarkText)
                    Spacer(Modifier.height(8.dp))
                    Text("Pronoun adalah kata yang digunakan untuk mengganti noun. Dalam hal ini, noun bisa jadi seseorang, suatu benda, tempat, bahkan tindakan atau gagasan. Yap, benda tersebut bisa jadi benda mati atau benda hidup.", fontSize = 12.sp, color = LightDarkText)
                    Spacer(Modifier.height(16.dp))
                    Text("Mari kita bahas suatu per satu macam-macam kata ganti dengan lebih detail!", fontSize = 12.sp, color = LightDarkText)
                    Spacer(Modifier.height(16.dp))
                    Box(
                        modifier = Modifier
                            .background(LightPrimaryGradient, RoundedCornerShape(4.dp))
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Do Exercise", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = LightOnPrimary)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun GrammarLessonLessonScreenPreview() {
    val navController = rememberNavController()
    GrammarLessonLessonScreen(navController)
}
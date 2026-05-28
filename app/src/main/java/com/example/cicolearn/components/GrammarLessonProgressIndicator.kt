package com.example.cicolearn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightLightText
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient
import com.example.cicolearn.ui.theme.LightSecondary
import com.example.cicolearn.ui.theme.LightSurface

@Composable
fun GrammarLessonProgressIndicator(progress: Int, sectionTitle: List<String>, selectedSection: Int) {
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
                    .widthIn(min = 120.dp , max = 280.dp)
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
            Text("$progress%", fontSize = 10.sp, fontWeight = FontWeight.Medium, color = LightLightText)
        }

        Spacer(Modifier.height(8.dp))

        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            progress = { progress/100.toFloat() },
            color = LightPrimary,
            trackColor = LightLightBorder,
            drawStopIndicator = {}
        )
    }
}
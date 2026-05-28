package com.example.cicolearn.components

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
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightLightText
import com.example.cicolearn.ui.theme.LightPrimary
import com.example.cicolearn.ui.theme.LightSurface

enum class LessonProgressIndicatorUnit {
    QUESTION, DIALOG
}

@Composable
fun LessonProgressIndicator(have: Int, mustHave: Int, unit: LessonProgressIndicatorUnit) {
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
                        append("$have/$mustHave ")
                    }
                    append(if (unit == LessonProgressIndicatorUnit.QUESTION) "question" else "dialog")
                },
                fontSize = 10.sp, fontWeight = FontWeight.Medium, color = LightLightText
            )
        }

        Spacer(Modifier.height(8.dp))

        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            progress = { have/mustHave.toFloat() },
            color = LightPrimary,
            trackColor = LightLightBorder,
            gapSize = 0.8.dp,
            drawStopIndicator = {}
        )
    }
}
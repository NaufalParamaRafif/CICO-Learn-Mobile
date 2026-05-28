package com.example.cicolearn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.R
import com.example.cicolearn.ui.theme.LightDanger
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightSuccess
import com.example.cicolearn.ui.theme.LightSurface

@Composable
fun LessonSpeakAccuracyFeedback(accuracy: Int, meaning: String) {
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
            Text("$accuracy%", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = LightSuccess)

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
                append(meaning)
            },
            fontSize = 12.sp,
            color = LightDarkText,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(Modifier.height(12.dp))

        PrimaryGradientElevatedButton("Next")
    }
}
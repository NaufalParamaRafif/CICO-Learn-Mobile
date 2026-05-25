package com.example.cicolearn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient

@Composable
fun VocabularyLessonSpeakSentenceCard(text: String, targetWord: String) {
    val words = text.split(" ")
    val annotatedString = buildAnnotatedString {
        words.forEach { word ->
            if (word == targetWord) {
                withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                    append("$word ")
                }
            } else {
                append("$word ")
            }
        }
    }

    Text(
        annotatedString,
        fontSize = 24.sp,
        fontWeight = FontWeight.Light,
        color = LightOnPrimary,
        modifier = Modifier
            .background(LightPrimaryGradient, RoundedCornerShape(8.dp))
            .padding(24.dp)
    )
}
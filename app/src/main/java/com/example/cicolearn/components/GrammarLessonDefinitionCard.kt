package com.example.cicolearn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
fun GrammarLessonDefinitonCard(word: String, meaning: String) {
    Column(
        modifier = Modifier
            .background(LightPrimaryGradient, RoundedCornerShape(8.dp))
            .padding(24.dp)
    ) {
        Text(word, fontSize = 24.sp, color = LightOnPrimary, fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(12.dp))

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                    append("Meaning: ")
                }
                append(meaning)
            },
            fontSize = 14.sp,
            color = LightOnPrimary,
        )
    }
}
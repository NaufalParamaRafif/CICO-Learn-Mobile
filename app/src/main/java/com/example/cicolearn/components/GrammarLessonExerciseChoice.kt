package com.example.cicolearn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightSurface

@Composable
fun GrammarLessonExerciseChoice(choice: String, text: String) {
    Row(
        modifier = Modifier
            .background(LightSurface, RoundedCornerShape(8.dp))
            .border(0.8.dp, LightLightBorder, RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(choice, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = LightDarkText)
        Spacer(Modifier.width(12.dp))
        Text(text, fontSize = 12.sp, color = LightDarkText, modifier = Modifier.weight(1f))
    }
}
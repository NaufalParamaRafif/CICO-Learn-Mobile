package com.example.cicolearn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBackground

@Composable
fun VocabularyLessonTypeWordTextField(modifier: Modifier = Modifier) {
    OutlinedTextField(
        modifier = Modifier
            .background(LightLightBackground)
            .fillMaxWidth()
            .height(44.dp)
            .border(0.8.dp, LightDarkBorder, RoundedCornerShape(4.dp)),
        state = TextFieldState(),
        placeholder = {
            Text(
                "Type Here",
                fontSize = 14.sp,
                color = LightDarkText.copy(0.35f),
                fontWeight = FontWeight.Medium
            )
        },
        lineLimits = TextFieldLineLimits.SingleLine,
        contentPadding = PaddingValues(start = 16.dp),
        textStyle = TextStyle(
            color = LightDarkText,
            fontSize = 14.sp,
        ),
    )
}
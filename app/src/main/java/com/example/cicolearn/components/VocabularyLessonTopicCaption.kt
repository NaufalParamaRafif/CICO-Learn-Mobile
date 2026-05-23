package com.example.cicolearn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient

@Composable
fun VocabularyLessonTopicCaption(title: String, description: String) {
    Box(
        modifier = Modifier
            .background(LightPrimaryGradient, RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .padding(24.dp),
        contentAlignment = Alignment.Center,

        ) {
        Column {
            Text(title, fontSize = 16.sp, color = LightOnPrimary, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(16.dp))
            Text(description, fontSize = 14.sp, color = LightOnPrimary)
        }
    }
}
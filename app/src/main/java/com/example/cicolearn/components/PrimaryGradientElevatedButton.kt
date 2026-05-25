package com.example.cicolearn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
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
fun PrimaryGradientElevatedButton(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth().padding(horizontal = 24.dp)
            .background(LightPrimaryGradient, RoundedCornerShape(4.dp)),
        contentAlignment = Alignment.Center,
    ) {
        Text(text, modifier = Modifier.padding(12.dp), fontWeight = FontWeight.Bold, fontSize = 16.sp, color = LightOnPrimary)
    }
}
package com.example.cicolearn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimary

@Composable
fun PrimaryLabelText(text: String) {
    Text(
        text,
        modifier = Modifier
            .background(LightPrimary, shape = RoundedCornerShape(100.dp))
            .padding(horizontal = 8.dp),
        color = LightOnPrimary,
        fontSize = 12.sp
    )
}
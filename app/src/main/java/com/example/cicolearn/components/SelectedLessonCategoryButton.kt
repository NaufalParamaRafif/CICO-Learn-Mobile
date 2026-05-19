package com.example.cicolearn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cicolearn.ui.theme.LightPrimaryGradient

@Composable
fun SelectedLessonCategoryButton(title: String) {
    Button(
        contentPadding = PaddingValues(),
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(4.dp),
    ) {
        Box(
            modifier = Modifier
                .background(brush = LightPrimaryGradient, shape = RoundedCornerShape(4.dp))
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(title)
        }
    }
}

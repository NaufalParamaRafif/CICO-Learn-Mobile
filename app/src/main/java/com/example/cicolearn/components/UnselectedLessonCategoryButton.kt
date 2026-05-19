package com.example.cicolearn.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightSecondary

@Composable
fun UnselectedLessonCategoryButton(title: String) {
    Button(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        onClick = {},
        colors = ButtonColors(
            containerColor = LightSecondary,
            contentColor = LightDarkText,
            disabledContentColor = Color.Green,
            disabledContainerColor = Color.Yellow
        ),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, LightDarkBorder)
    ) {
        Text(title)
    }
}

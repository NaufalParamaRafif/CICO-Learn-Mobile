package com.example.cicolearn.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.R
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightSecondary

@Composable
fun FilterSelectedCategoryLessonDropDownButton(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.background(LightSecondary),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, LightDarkBorder),
        contentColor = LightDarkText
    ) {
        Row(
            modifier = Modifier
                .background(LightSecondary)
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Selected", fontWeight = FontWeight.Medium, fontSize = 14.sp)
            Icon(painter = painterResource(R.drawable.ic_category_lesson_filter), contentDescription = null)
        }
    }
}

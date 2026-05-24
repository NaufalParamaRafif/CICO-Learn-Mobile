package com.example.cicolearn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.R
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightSurface

@Composable
fun VocabularyLessonExampleItem(example: String, meaning: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(LightSurface, RoundedCornerShape(4.dp))
            .border(0.8.dp, LightDarkBorder, RoundedCornerShape(4.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(LightSurface, RoundedCornerShape(4.dp))
                .border(0.8.dp, LightDarkBorder, RoundedCornerShape(4.dp))
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(example, fontSize = 12.sp, fontWeight = FontWeight.Medium, color = LightDarkText)
            Icon(
                painter = painterResource(R.drawable.ic_expand_more),
                contentDescription = null
            )
        }
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Meaning: ")
                }
                append(meaning)
            },
            fontSize = 12.sp, fontWeight = FontWeight.Medium, color = LightDarkText,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
        )
    }
    Spacer(Modifier.height(12.dp))
}
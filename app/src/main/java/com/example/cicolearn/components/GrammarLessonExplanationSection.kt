package com.example.cicolearn.components

import android.util.ArrayMap
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient
import com.example.cicolearn.ui.theme.LightSurface

@Composable
fun GrammarLessonExplanationSection(sectionTitle: String, sectionIndex: Int, exerciseExist: Boolean = false, headerExplanations: ArrayMap<String, String>) {
    Column(
        modifier = Modifier
            .background(LightSurface, RoundedCornerShape(8.dp))
            .border(0.8.dp, LightDarkBorder, RoundedCornerShape(8.dp))
    ) {
        Box(
            modifier = Modifier
                .background(LightPrimaryGradient, RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                        append("Section $sectionIndex: ")
                    }
                    append(sectionTitle)
                },
                fontSize = 14.sp,
                color = LightOnPrimary,
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            headerExplanations.forEach { (header, explanation) ->
                Text(header, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = LightDarkText)
                Spacer(Modifier.height(8.dp))
                Text(explanation, fontSize = 12.sp, color = LightDarkText)
                Spacer(Modifier.height(16.dp))
            }

            if (exerciseExist) {
                Box(
                    modifier = Modifier
                        .background(LightPrimaryGradient, RoundedCornerShape(4.dp))
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Do Exercise", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = LightOnPrimary)
                }
            }
        }
    }
}
package com.example.cicolearn.components

import androidx.collection.ArrayMap
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient
import com.example.cicolearn.ui.theme.LightSemiDarkText
import com.example.cicolearn.ui.theme.LightSurface

@Composable
fun TrainWithAIRulesPopup(title: String, textButton: String, ruleAndCaption: ArrayMap<String, String>) {
    Column(
        modifier = Modifier
            .background(LightSurface, RoundedCornerShape(8.dp))
            .border(0.8.dp, LightLightBorder, RoundedCornerShape(8.dp))
            .padding(24.dp)
    ) {
        Text(title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = LightDarkText, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())

        Spacer(Modifier.height(16.dp))

        ruleAndCaption.forEach { (ruleTitle, ruleCaption) ->
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(ruleTitle)
                    }
                    append(ruleCaption)
                },
                fontSize = 14.sp, color = LightSemiDarkText
            )

            Spacer(Modifier.height(8.dp))
        }

        Spacer(Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(LightPrimaryGradient, RoundedCornerShape(4.dp)),
            contentAlignment = Alignment.Center,
        ) {
            Text(textButton, modifier = Modifier.padding(12.dp), fontWeight = FontWeight.Bold, fontSize = 16.sp, color = LightOnPrimary)
        }
    }
}
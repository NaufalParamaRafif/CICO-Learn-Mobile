package com.example.cicolearn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.R
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient

@Composable
fun VocabularyLessonWordDefinitionCard(word: String, meaning: String, synonyms: String, phoneticTranscriptionUK: String, phoneticTranscriptionUS: String) {
    Column(
        modifier = Modifier
            .background(LightPrimaryGradient, RoundedCornerShape(8.dp))
            .padding(16.dp),
    ) {
        Text(word, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = LightOnPrimary)

        Spacer(Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .background(LightOnPrimary.copy(0.35f), RoundedCornerShape(256.dp))
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text("US", fontSize = 10.sp, color = LightOnPrimary, fontWeight = FontWeight.Bold)
                Spacer(Modifier.width(4.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_small_sound),
                    tint = LightOnPrimary ,
                    contentDescription = null
                )
                Spacer(Modifier.width(4.dp))
                Text(phoneticTranscriptionUS, fontSize = 10.sp, color = LightOnPrimary)
            }
            Spacer(Modifier.width(8.dp))
            Row(
                modifier = Modifier
                    .background(LightOnPrimary.copy(0.35f), RoundedCornerShape(256.dp))
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text("UK", fontSize = 10.sp, color = LightOnPrimary, fontWeight = FontWeight.Bold)
                Spacer(Modifier.width(4.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_small_sound),
                    tint = LightOnPrimary ,
                    contentDescription = null
                )
                Spacer(Modifier.width(4.dp))
                Text(phoneticTranscriptionUK, fontSize = 10.sp, color = LightOnPrimary)
            }
        }

        Spacer(Modifier.height(8.dp))

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 14.sp, color = LightOnPrimary, fontWeight = FontWeight.Bold)) {
                    append("Meaning: ")
                }
                withStyle(style = SpanStyle(fontSize = 14.sp, color = LightOnPrimary)) {
                    append(meaning)
                }
            }
        )

        Spacer(Modifier.height(8.dp))

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 14.sp, color = LightOnPrimary, fontWeight = FontWeight.Bold)) {
                    append("Synonyms: ")
                }
                withStyle(style = SpanStyle(fontSize = 14.sp, color = LightOnPrimary)) {
                    append(synonyms)
                }
            }
        )
    }
}
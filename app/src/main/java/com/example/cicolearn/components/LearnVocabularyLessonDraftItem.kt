package com.example.cicolearn.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.R
import com.example.cicolearn.ui.theme.LightDarkText

@Composable
fun LearnVocabularyLessonDraftItem(draftName: String, isSaved: Boolean = false) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .size(32.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(4.dp)),
            painter = painterResource(R.drawable.introduction_image),
            contentDescription = null
        )

        Spacer(Modifier.width(16.dp))

        Text("IELTS Words", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = LightDarkText, modifier = Modifier.weight(1f))

        Spacer(Modifier.width(16.dp))

        IconButton(
            modifier = Modifier
                .background(Color(0xFFA6BFF2).copy(alpha = 0.15f), shape = CircleShape)
                .size(44.dp),
            onClick = {}
        ) {
            Icon(
                painter = if (isSaved) painterResource(R.drawable.ic_saved) else painterResource(R.drawable.ic_save),
//                painter = painterResource(R.drawable.ic_saved),
                contentDescription = null
            )
        }
    }
}
package com.example.cicolearn.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.R
import com.example.cicolearn.ui.theme.LightBottomNavigationLightText
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder

@Composable
fun LearnVocabularyLessonTopicWordItem(title: String, description: String, isSaved: Boolean = false) {
    Row(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
    ) {
        Image(
            modifier = Modifier.size(40.dp).aspectRatio(1f),
            painter = painterResource(R.drawable.introduction_image),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Spacer(Modifier.width(12.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(title, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = LightDarkText)
            Spacer(Modifier.height(8.dp))
            Text(description, fontSize = 12.sp, color = LightBottomNavigationLightText)
        }
        Spacer(Modifier.width(12.dp))
        IconButton(
            modifier = Modifier
                .background(Color(0xFFA6BFF2).copy(alpha = 0.15f), shape = CircleShape),
            onClick = {}
        ) {
            Icon(
                painter = if (isSaved) painterResource(R.drawable.ic_saved) else painterResource(R.drawable.ic_save),
                contentDescription = null
            )
        }
    }
    HorizontalDivider(thickness = 0.8.dp, color = LightLightBorder, modifier = Modifier.padding(horizontal = 8.dp))
}
package com.example.cicolearn.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.R
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightLightText
import com.example.cicolearn.ui.theme.LightSurface

@Composable
fun TrainWithAIHistoryItem(title: String, lessonTime: String, timeAgo: String, optionalLabel: String? = null) {
    Card(
        modifier = Modifier.padding(horizontal = 24.dp).fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = LightSurface,
            contentColor = LightLightText,
        ),
        border = BorderStroke(0.8.dp, LightLightBorder),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(40.dp).clip(CircleShape),
                painter = painterResource(R.drawable.introduction_image),
                contentDescription = null
            )
            Spacer(Modifier.width(16.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = LightDarkText)
                if(optionalLabel.isNullOrBlank()) {
                    Spacer(Modifier.height(8.dp))
                } else {
                    Spacer(Modifier.height(4.dp))
                    PrimaryLabelText(optionalLabel)
                    Spacer(Modifier.height(4.dp))
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(lessonTime, fontSize = 10.sp)
                    Text(timeAgo, fontSize = 10.sp)
                }
            }
        }
    }
    Spacer(Modifier.height(16.dp))
}
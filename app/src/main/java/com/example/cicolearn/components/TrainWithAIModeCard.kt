package com.example.cicolearn.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.example.cicolearn.BottomBarScreen
import com.example.cicolearn.R
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightLightText
import com.example.cicolearn.ui.theme.LightSurface

@Composable
fun TrainWithAIModeCard(title: String, description: String) {
    Card(
        modifier = Modifier
            .border(1.dp, LightLightBorder, RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(
            contentColor = LightLightText,
            containerColor = LightSurface
        ),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(48.dp).clip(CircleShape),
                painter = painterResource(R.drawable.introduction_image),
                contentDescription = null
            )
            Spacer(Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = LightDarkText)
                Spacer(Modifier.height(4.dp))
                Text(description, fontWeight = FontWeight.Medium)
            }
        }
    }
}
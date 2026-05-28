package com.example.cicolearn.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimary
import com.example.cicolearn.ui.theme.LightSurface

@Composable
fun MemorizeHistoryItem(title: String, totalVocabulary: Int, time: String, haveMemorizeVocab: Int, mustHaveMemorizeVocab: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, color = LightLightBorder, shape = RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(
            containerColor = LightSurface,
            contentColor = LightDarkText
        ),
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(48.dp).clip(CircleShape),
                painter =  painterResource(R.drawable.introduction_image),
                contentDescription = null,
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 12.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                Text(
                    title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = LightDarkText
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    "$totalVocabulary Vocabulary",
                    modifier = Modifier
                        .background(LightPrimary, shape = RoundedCornerShape(100.dp))
                        .padding(horizontal = 8.dp),
                    color = LightOnPrimary,
                    fontSize = 12.sp
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    time,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = LightLightText
                )
            }
            Box(
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("$haveMemorizeVocab/$mustHaveMemorizeVocab", fontSize = 13.sp, fontWeight = FontWeight.SemiBold, )
                    Text("Vocab", fontSize = 10.sp, fontWeight = FontWeight.Medium)
                }
                CircularProgressIndicator(
                    color = LightPrimary,
                    trackColor = LightLightBorder,
                    modifier = Modifier.size(48.dp),
                    progress = { (3/4).toFloat() },
                    strokeWidth = 3.dp,
                    gapSize = 0.dp
                )
            }
        }
    }
}
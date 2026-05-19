package com.example.cicolearn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.R
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient

@Composable
fun StreakCard() {
    ElevatedCard(
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.Transparent,
            contentColor = LightOnPrimary
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = LightPrimaryGradient,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 24.dp, vertical = 24.dp)
        ) {
            Column {
                Text("Streak", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("3 days")
                    Text("121 lessons")
                }
                Spacer(Modifier.height(24.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(painter = painterResource(R.drawable.streak_fire_off), contentDescription = null)
                    Icon(painter = painterResource(R.drawable.streak_fire_off), contentDescription = null)
                    Icon(painter = painterResource(R.drawable.streak_fire_off), contentDescription = null)
                    Icon(painter = painterResource(R.drawable.streak_fire_off), contentDescription = null)
                    Icon(painter = painterResource(R.drawable.streak_fire_off), contentDescription = null)
                    Icon(painter = painterResource(R.drawable.streak_fire_off), contentDescription = null)
                    Icon(painter = painterResource(R.drawable.streak_fire_off), contentDescription = null)
                }
            }
        }
    }
}

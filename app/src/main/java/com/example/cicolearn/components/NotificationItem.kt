package com.example.cicolearn.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightLightText

@Composable
fun NotificationItem(title : String, text : String, timeDistace: String) {
    HorizontalDivider(thickness = 1.dp, color = LightLightBorder)
    Row (
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(String(Character.toChars(128536)), fontSize = 40.sp)
        Spacer(Modifier.width(16.dp))
        Column(
        ) {
            Text(title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = LightDarkText)
            Spacer(Modifier.height(4.dp))
            Text(
                text,
                fontSize = 14.sp,
                color = LightDarkText,
                fontWeight = FontWeight.W400,
                lineHeight = 16.sp
            )
            Spacer(Modifier.height(4.dp))
            Text("$timeDistace ago", fontSize = 12.sp, color = LightLightText, fontWeight = FontWeight.Normal)
        }
    }
}

package com.example.cicolearn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.R
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient
import com.example.cicolearn.ui.theme.LightSecondary

@Composable
fun BottomMicAndSpeakerComponent(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier
                .background(LightSecondary, CircleShape)
                .border(0.8.dp, LightDarkBorder, CircleShape)
                .size(56.dp)
                .aspectRatio(1f)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_pronounciation_sound),
                    contentDescription = null
                )
                Text("0.75x", fontSize = 8.sp, modifier = Modifier.align(Alignment.BottomEnd))
            }
        }

        Spacer(Modifier.width(24.dp))

        IconButton(
            onClick = {},
            modifier = Modifier
                .background(LightPrimaryGradient, CircleShape)
                .size(64.dp)
                .aspectRatio(1f)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_mic_speak),
                contentDescription = null,
                tint = LightOnPrimary
            )
        }

        Spacer(Modifier.width(24.dp))

        IconButton(
            onClick = {},
            modifier = Modifier
                .background(LightSecondary, CircleShape)
                .border(0.8.dp, LightDarkBorder, CircleShape)
                .size(56.dp)
                .aspectRatio(1f)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_pronounciation_sound),
                contentDescription = null
            )
        }
    }
}
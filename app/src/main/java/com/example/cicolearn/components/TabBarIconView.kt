package com.example.cicolearn.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimary

@Composable
fun TabBarIconView(
    isSelected: Boolean,
    @DrawableRes selectedIcon: Int,
    @DrawableRes unselectedIcon: Int,
    title: String,
) {
    if (isSelected) {
        Surface(
            color = LightPrimary,
            shape = RoundedCornerShape(8.dp)
        ) {
            Icon(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .background(color = LightPrimary),
                painter = painterResource(selectedIcon),
                contentDescription = title,
                tint = LightOnPrimary
            )
        }
    } else {
        Icon(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            painter = painterResource(unselectedIcon),
            contentDescription = null,
            tint = LightDarkText
        )
    }
}

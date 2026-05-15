package com.example.cicolearn.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

// Light Custom Color
val LightBackground = Color(0xFFF1F5FD)
val LightPrimary = Color(0xFF306EE8)
val LightPrimaryDark = Color(0xFF144BB8)
val LightOnPrimary = Color(0xFFE8EFFC)
val LightSecondary = Color(0xFFF2F2F2)
val LightSurface = Color(0xFFFAFCFE)
val LightDarkText = Color(0xFF3D475C)
val LightLightText = Color(0xFF94A0B8)
val LightDarkBorder = Color(0xFF667799)
val LightLightBorder = Color(0xFFB7C0D1)
val LightBottomNavigationLightText = Color(0xFF5C6B8A)

val LightPrimaryGradient = Brush.linearGradient(
    colors = listOf(LightPrimary, LightPrimaryDark),
    start = Offset(0f, Float.POSITIVE_INFINITY),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)

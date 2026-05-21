package com.example.cicolearn.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.ProgressIndicatorDefaults.circularColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.R
import com.example.cicolearn.components.DraftMemorizeCard
import com.example.cicolearn.components.LessonCard
import com.example.cicolearn.components.TopAppBarSearch
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimary
import com.example.cicolearn.ui.theme.LightSurface

@Composable
fun MemorizeScreen(navController: NavHostController) {
    Scaffold(
        containerColor = LightBackground,
        topBar = {
            TopAppBarSearch(navController = navController, R.drawable.ic_history, "", "Search draft...")
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(16.dp)
        ) {
            Text(
                "Today's vocab",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = LightDarkText
            )
            Spacer(Modifier.height(12.dp))
            LessonCard("Vocab for Today", 100, 3)

            Spacer(Modifier.height(24.dp))
            Text(
                "Your Draft:",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = LightDarkText
            )
            Spacer(Modifier.height(12.dp))
            Column {
                DraftMemorizeCard(
                    "Introduction at Office",
                    500,
                    3,
                    4
                )
            }
        }
    }
}

@Preview
@Composable
private fun MemorizeScreenPreview() {
    val navController = rememberNavController()
    MemorizeScreen(navController = navController)
}
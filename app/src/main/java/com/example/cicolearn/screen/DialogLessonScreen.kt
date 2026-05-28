package com.example.cicolearn.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.R
import com.example.cicolearn.components.LessonProgressIndicator
import com.example.cicolearn.components.LessonProgressIndicatorUnit
import com.example.cicolearn.components.SystemDialogCard
import com.example.cicolearn.components.TopAppBarBack
import com.example.cicolearn.components.UserDialogCard
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient

@Composable
fun DialogLessonScreen(navController: NavController) {
    Scaffold(
        containerColor = LightBackground,
        topBar = {
            TopAppBarBack(
                navController,
                "Learn Dialog"
            )
        },
        floatingActionButton = {
                IconButton (
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
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding).padding(horizontal = 24.dp)
        ) {
            LessonProgressIndicator(10, 21, LessonProgressIndicatorUnit.DIALOG)

            Spacer(Modifier.height(16.dp))

            SystemDialogCard("So it's a tool to be used to develop and enhance what you do!")

            Spacer(Modifier.height(16.dp))

            UserDialogCard("So it's a tool to be used to develop and enhance what you do!", true)
        }
    }
}

@Preview
@Composable
private fun DialogLessonScreenPreview() {
    val navController = rememberNavController()
    DialogLessonScreen(navController)
}
package com.example.cicolearn.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cicolearn.R
import com.example.cicolearn.components.NotificationItem
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(painter = painterResource(R.drawable.ic_back_button), contentDescription = null, tint = LightDarkText)
                    }
                },
                title = {
                    Text("Notification", fontWeight = FontWeight.Bold, color = LightDarkText, fontSize = 20.sp)
                },
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding)
        ) {
            NotificationItem(
                title = "Welcome!",
                text = "Welcome to CICO Learn app, hope you find this app useful and helpful in your learning journey!",
                timeDistace = "1 hour"
            )
            NotificationItem(
                title = "Don't Give Up!",
                text = "I know, this isn't easy, but with hardwork, persistance, consistency, discipline, you will make it!",
                timeDistace = "3 hour"
            )
            HorizontalDivider(thickness = 1.dp, color = LightLightBorder)
        }
    }
}

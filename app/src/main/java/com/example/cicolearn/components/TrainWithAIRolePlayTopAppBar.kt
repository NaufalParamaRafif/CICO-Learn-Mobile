package com.example.cicolearn.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cicolearn.R
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainWithAIRolePlayTopAppBar(navController: NavController, title: String, topic: String) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = LightBackground
        ),
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
            Column {
                Text(title, fontWeight = FontWeight.Bold, color = LightDarkText, fontSize = 16.sp)
                PrimaryLabelText(topic)
            }
        },
    )
}
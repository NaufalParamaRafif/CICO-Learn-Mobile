package com.example.cicolearn.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.BottomBarScreen
import com.example.cicolearn.R
import com.example.cicolearn.components.TrainWithAIModeCard
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightLightText
import com.example.cicolearn.ui.theme.LightSurface

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainWithAIScreen(navController: NavHostController) {
    Scaffold(
        containerColor = LightBackground,
        topBar = {
           TopAppBar(
               colors = TopAppBarDefaults.topAppBarColors(
                   containerColor = LightBackground
               ),
               title = {
                   Text(
                       "Choose Mode!",
                       fontSize = 18.sp,
                       fontWeight = FontWeight.Bold
                   )
               },
               actions = {
                   IconButton(
                       onClick = {
                       }
                   ) {
                       Icon(painter = painterResource(R.drawable.ic_history), contentDescription = null, tint = LightDarkText)
                   }
               }
           )
       }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(16.dp)
        ) {
            Text("Mode:", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
            Spacer(Modifier.height(16.dp))
            TrainWithAIModeCard(title = "Free Talk", "This is description This is description This is description This is description This is description This is description This is description")
        }
    }
}

@Preview
@Composable
private fun TrainWithAIPreview() {
    val navController = rememberNavController()
    TrainWithAIScreen(navController)
}
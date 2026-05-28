package com.example.cicolearn.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.components.TopAppBarBack
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient

@Composable
fun MemorizeChooseModeScreen(navController: NavController) {
    Scaffold(
        containerColor = LightBackground,
        topBar = {
            TopAppBarBack(
                navController,
                "Memorize Vocabulary"
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding).fillMaxSize().padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Choose between this one!", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = LightDarkText, modifier = Modifier.fillMaxWidth())

            Spacer(Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LightPrimaryGradient, RoundedCornerShape(4.dp))
                    .padding(horizontal = 24.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text("Memorize All Vocabulary", modifier = Modifier.padding(12.dp), fontWeight = FontWeight.Bold, fontSize = 16.sp, color = LightOnPrimary)
            }

            Spacer(Modifier.height(20.dp))

            Text("OR", fontSize = 16.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, color = LightDarkText, modifier = Modifier.fillMaxWidth())

            Spacer(Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LightPrimaryGradient, RoundedCornerShape(4.dp))
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text("Memorize System's Recommended Vocab", modifier = Modifier.padding(12.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = LightOnPrimary)
            }
        }
    }
}

@Preview
@Composable
private fun MemorizeChooseModeScreenPreview() {
    val navController = rememberNavController()
    MemorizeChooseModeScreen(navController)
}
package com.example.cicolearn.screen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.cicolearn.R
import com.example.cicolearn.components.FilterSelectedCategoryLessonDropDownButton
import com.example.cicolearn.components.LessonCard
import com.example.cicolearn.components.SelectedLessonCategoryButton
import com.example.cicolearn.components.StreakCard
import com.example.cicolearn.components.TopAppBarSearch
import com.example.cicolearn.components.UnselectedLessonCategoryButton
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkText

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        containerColor = LightBackground,
        topBar = {
            TopAppBarSearch(
                navController = navController,
                destinationRoute = "Search",
                actionIcon = R.drawable.ic_top_app_bar_notification,
                actionDestinationRoute = "Notification",
                placeHolderText = "Search words, phrases..."
            )
        },
    ) { innerPadding ->
        val scrollLessonsCategoryState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(String(Character.toChars(128536)), fontSize = 32.sp)
                Spacer(Modifier.width(8.dp))
                Text(
                    "Hello ..! Mumpung otak masih fresh nih, mau belajar apa?",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp, color = LightDarkText,
                    lineHeight = 20.sp
                )
            }
            Spacer(Modifier.height(16.dp))
            StreakCard()
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(scrollLessonsCategoryState),
                horizontalArrangement = Arrangement.spacedBy(8.dp),

                ) {
                SelectedLessonCategoryButton("Recent Lessons")
                UnselectedLessonCategoryButton("Vocabulary")
                UnselectedLessonCategoryButton("Grammar")
                UnselectedLessonCategoryButton("Dialog")
            }
            Spacer(Modifier.height(16.dp))
            FilterSelectedCategoryLessonDropDownButton()
            Spacer(Modifier.height(16.dp))
            LessonCard("Foods", 67, 100)
        }
    }
}

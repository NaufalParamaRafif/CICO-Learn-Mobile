package com.example.cicolearn.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.R
import com.example.cicolearn.components.OptionProfileItem
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDanger
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightLightText
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient
import com.example.cicolearn.ui.theme.LightSemiDarkText
import com.example.cicolearn.ui.theme.LightSuccess
import com.example.cicolearn.ui.theme.LightSurface
import kotlin.random.Random

@Composable
fun ProfileScreen() {
    val daysMonth = (1..30).toList()
    Scaffold (
        containerColor = LightBackground,
    ) { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding).fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.height(240.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.background_profile),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .size(128.dp)
                        .clip(CircleShape)
                        .border(2.dp, LightLightBorder, CircleShape)
                        .align(Alignment.BottomCenter),
                    painter = painterResource(R.drawable.profile_photo),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }

            Spacer(Modifier.height(8.dp))

            Text(
                "Bagastian Ade ni Anjani Haraheta Arabian Kebab Niantiara",
                modifier = Modifier.padding(horizontal = 32.dp),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = LightDarkText
            )

            Spacer(Modifier.height(16.dp))

            Surface(
                modifier = Modifier.padding(horizontal = 32.dp),
                color = LightSurface,
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(0.8.dp, LightLightBorder)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Activity",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = LightDarkText
                        )
                        Text(
                            "this month",
                            fontWeight = FontWeight.Light,
                            fontSize = 12.sp,
                            color = LightLightText
                        )
                    }

                    Spacer(Modifier.height(8.dp))

                    HorizontalDivider(thickness = 1.dp, color = LightLightBorder)

                    Spacer(Modifier.height(12.dp))

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(8),
                        userScrollEnabled = false,
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        items(daysMonth) { day ->
                            if (Random.nextBoolean()) {
                                Box (
                                    modifier = Modifier
                                        .background(LightPrimaryGradient, shape = RoundedCornerShape(4.dp))
                                        .aspectRatio(1f),
                                    contentAlignment = Alignment.Center,
                                ) {
                                    Text(
                                        day.toString(),
                                        color = LightOnPrimary,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp
                                    )
                                }
                            } else {
                                Box (
                                    modifier = Modifier
                                        .background(LightSurface, shape = RoundedCornerShape(4.dp))
                                        .aspectRatio(1f)
                                        .border(0.8.dp, LightLightBorder, RoundedCornerShape(4.dp)),
                                    contentAlignment = Alignment.Center,
                                ) {
                                    Text(
                                        day.toString(),
                                        color = LightDarkText,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            Surface(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                color = LightSurface,
                contentColor = LightSemiDarkText,
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(0.8.dp, LightLightBorder)
            ) {
                Column {
                    OptionProfileItem(R.drawable.ic_account, "Account")
                    OptionProfileItem(R.drawable.ic_english_level, "Level", "intermediate")
                    OptionProfileItem(R.drawable.ic_language, "Language", "English")
                    OptionProfileItem(R.drawable.ic_target, "Target", "Job Interview")
                    OptionProfileItem(R.drawable.ic_dailty_reminder, "Daily Reminder", "ON")
                    OptionProfileItem(R.drawable.ic_time_target_daily, "Time Target", "30 Minutes")
                }
            }

            Spacer(Modifier.height(16.dp))

            Surface(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                color = LightSurface,
                contentColor = LightSemiDarkText,
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(0.8.dp, LightLightBorder)
            ) {
                OptionProfileItem(R.drawable.ic_contact_us, "Contact Us", optionalColor = LightSuccess, showExpandMoreIcon = false)
            }

            Spacer(Modifier.height(16.dp))

            Surface(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                color = LightSurface,
                contentColor = LightSemiDarkText,
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(0.8.dp, LightLightBorder)
            ) {
                OptionProfileItem(R.drawable.ic_logout, "Logout", optionalColor = LightDanger, showExpandMoreIcon = false)
            }

            Spacer(Modifier.height(16.dp))

            Surface(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                color = LightSurface,
                contentColor = LightSemiDarkText,
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(0.8.dp, LightLightBorder)
            ) {
                OptionProfileItem(R.drawable.ic_delete_account, "Delete Account", optionalColor = LightDanger, showExpandMoreIcon = false)
            }
        }
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen()
}
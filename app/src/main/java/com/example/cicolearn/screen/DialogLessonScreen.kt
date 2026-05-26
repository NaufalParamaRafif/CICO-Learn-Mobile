package com.example.cicolearn.screen

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cicolearn.R
import com.example.cicolearn.components.TopAppBarBack
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightLightText
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient
import com.example.cicolearn.ui.theme.LightSecondary
import com.example.cicolearn.ui.theme.LightSurface

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
            Column(
                modifier = Modifier
                    .background(LightSurface, RoundedCornerShape(8.dp))
                    .border(0.8.dp, LightLightBorder, RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Progress", fontSize = 10.sp, fontWeight = FontWeight.Medium, color = LightLightText)
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("1/34 ")
                            }
                            append("question")
                        },
                        fontSize = 10.sp, fontWeight = FontWeight.Medium, color = LightLightText
                    )
                }

                Spacer(Modifier.height(8.dp))

                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth(),
                    progress = {0.3f},
                    color = LightPrimary,
                    trackColor = LightLightBorder,
                    drawStopIndicator = {}
                )
            }
            
            Spacer(Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 48.dp)
                    .background(LightPrimaryGradient, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Text("So it's a tool to be used to develop and enhance what you do!", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = LightOnPrimary)

                Spacer(Modifier.height(16.dp))

                Row(

                ) {
                    IconButton (
                        onClick = {},
                        modifier = Modifier
                            .background(LightSecondary.copy(0.6f), CircleShape)
                            .border(0.8.dp, LightLightBorder, CircleShape)
                            .size(40.dp)
                            .aspectRatio(1f)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.size(28.dp)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_pronounciation_sound),
                                contentDescription = null,
                                modifier = Modifier.size(16.dp),
                                tint = LightDarkText
                            )
                            Text("0.75x", fontSize = 6.sp, modifier = Modifier.align(Alignment.BottomEnd), color = LightDarkText)
                        }
                    }

                    Spacer(Modifier.width(8.dp))

                    IconButton (
                        onClick = {},
                        modifier = Modifier
                            .background(LightSecondary.copy(0.6f), CircleShape)
                            .border(0.8.dp, LightLightBorder, CircleShape)
                            .size(40.dp)
                            .aspectRatio(1f)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_pronounciation_sound),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = LightDarkText
                        )
                    }

                    Spacer(Modifier.weight(1f))

                    IconButton (
                        onClick = {},
                        modifier = Modifier
                            .background(LightSecondary.copy(0.6f), CircleShape)
                            .border(0.8.dp, LightLightBorder, CircleShape)
                            .size(40.dp)
                            .aspectRatio(1f)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_translate),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = LightDarkText
                        )
                    }

                }
            }

            Spacer(Modifier.height(16.dp))

            Text("Speak this sentence!", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = LightDarkText, textAlign = TextAlign.End , modifier = Modifier.fillMaxWidth().padding(start = 56.dp))

            Spacer(Modifier.height(12.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 48.dp)
                    .background(LightSurface, RoundedCornerShape(8.dp))
                    .border(0.8.dp, LightLightBorder, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Text("So it's a tool to be used to develop and enhance what you do!", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = LightDarkText)

                Spacer(Modifier.height(16.dp))

                Row(

                ) {
                    IconButton (
                        onClick = {},
                        modifier = Modifier
                            .background(LightSecondary.copy(0.6f), CircleShape)
                            .border(0.8.dp, LightLightBorder, CircleShape)
                            .size(40.dp)
                            .aspectRatio(1f)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.size(28.dp)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_pronounciation_sound),
                                contentDescription = null,
                                modifier = Modifier.size(16.dp),
                                tint = LightDarkText
                            )
                            Text("0.75x", fontSize = 6.sp, modifier = Modifier.align(Alignment.BottomEnd), color = LightDarkText)
                        }
                    }

                    Spacer(Modifier.width(8.dp))

                    IconButton (
                        onClick = {},
                        modifier = Modifier
                            .background(LightSecondary.copy(0.6f), CircleShape)
                            .border(0.8.dp, LightLightBorder, CircleShape)
                            .size(40.dp)
                            .aspectRatio(1f)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_pronounciation_sound),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = LightDarkText
                        )
                    }

                    Spacer(Modifier.weight(1f))

                    IconButton (
                        onClick = {},
                        modifier = Modifier
                            .background(LightSecondary.copy(0.6f), CircleShape)
                            .border(0.8.dp, LightLightBorder, CircleShape)
                            .size(40.dp)
                            .aspectRatio(1f)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_translate),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = LightDarkText
                        )
                    }

                }
            }
        }
    }
}

@Preview
@Composable
private fun DialogLessonScreenPreview() {
    val navController = rememberNavController()
    DialogLessonScreen(navController)
}
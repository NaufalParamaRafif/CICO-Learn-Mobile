package com.example.cicolearn.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.cicolearn.BottomBarScreen
import com.example.cicolearn.R
import com.example.cicolearn.components.PrimaryLabelText
import com.example.cicolearn.components.TopAppBarBack
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightLightText
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient
import com.example.cicolearn.ui.theme.LightSecondary
import com.example.cicolearn.ui.theme.LightSemiDarkText
import com.example.cicolearn.ui.theme.LightSurface

// TODO: REFACTOR THIS SCREEN 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainWithAIRolePlayScreen(navController: NavController) {
    Scaffold(
        containerColor = LightBackground,
        topBar = {
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
                        Text("Role Play", fontWeight = FontWeight.Bold, color = LightDarkText, fontSize = 16.sp)
                        PrimaryLabelText("Ticket to Ride")
                    }
                },
            )
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 24.dp)
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
                        Text(
                            "Progress",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = LightLightText
                        )
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
                        progress = { 0.3f },
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
                    Text(
                        "So it's a tool to be used to develop and enhance what you do!",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = LightOnPrimary
                    )

                    Spacer(Modifier.height(16.dp))

                    Row(

                    ) {
                        IconButton(
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
                                Text(
                                    "0.75x",
                                    fontSize = 6.sp,
                                    modifier = Modifier.align(Alignment.BottomEnd),
                                    color = LightDarkText
                                )
                            }
                        }

                        Spacer(Modifier.width(8.dp))

                        IconButton(
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

                        IconButton(
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

            Box(
                modifier = Modifier
                    .background(Color.Black.copy(0.54f))
                    .fillMaxSize()
                    .padding(horizontal = 32.dp),
                contentAlignment = Alignment.Center
            ) {
//                Column(
//                    modifier = Modifier
//                        .background(LightSurface, RoundedCornerShape(8.dp))
//                        .border(0.8.dp, LightLightBorder, RoundedCornerShape(8.dp))
//                        .padding(24.dp)
//                ) {
//                    Text("Role Play Rules", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = LightDarkText, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
//
//                    Spacer(Modifier.height(16.dp))
//
//                    Text("You are at a train station ticket counter and need to buy a ticket to another city. Speak clearly and politely with the ticket officer. Ask about the destination, departure time, ticket price, and available seats. You may also ask follow-up questions if something is unclear. Keep your sentences natural and conversational. Do not give one-word answers, and avoid switching to another language. Try to complete the purchase by confirming the ticket details and thanking the officer at the end.", fontSize = 14.sp, color = LightSemiDarkText)
//
//                    Spacer(Modifier.height(16.dp))
//
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(LightPrimaryGradient, RoundedCornerShape(4.dp)),
//                        contentAlignment = Alignment.Center,
//                    ) {
//                        Text("OK", modifier = Modifier.padding(12.dp), fontWeight = FontWeight.Bold, fontSize = 16.sp, color = LightOnPrimary)
//                    }
//                }
                Column(
                    modifier = Modifier
                        .background(LightSurface, RoundedCornerShape(8.dp))
                        .border(0.8.dp, LightLightBorder, RoundedCornerShape(8.dp))
                        .padding(24.dp)
                ) {
                    Text("Challange Rules", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = LightDarkText, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())

                    Spacer(Modifier.height(16.dp))

                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Your task: ")
                            }
                            append("Choose a scientific concept and explain it as clearly as possible. Imagine you are teaching someone who has basic curiosity but little technical knowledge.")
                        },
                        fontSize = 14.sp, color = LightSemiDarkText
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Focus on clarity: ")
                            }
                            append("Break the idea into simple steps so the listener can follow your reasoning.")
                        },
                        fontSize = 14.sp, color = LightSemiDarkText
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Use examples: ")
                            }
                            append("Real-life examples or analogies are encouraged to make the concept easier to understand.\n" + "Structure your explanation: Start with the main idea, then explain how it works, and finish with why it matters.")
                        },
                        fontSize = 14.sp, color = LightSemiDarkText
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Goal: ")
                            }
                            append("By the end, the listener should understand the concept and why it is interesting or useful.")
                        },
                        fontSize = 14.sp, color = LightSemiDarkText
                    )

                    Spacer(Modifier.height(16.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(LightPrimaryGradient, RoundedCornerShape(4.dp)),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text("OK", modifier = Modifier.padding(12.dp), fontWeight = FontWeight.Bold, fontSize = 16.sp, color = LightOnPrimary)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun TrainWithAIRolePlayScreenPreview() {
    val navController = rememberNavController()
    TrainWithAIRolePlayScreen(navController)
}
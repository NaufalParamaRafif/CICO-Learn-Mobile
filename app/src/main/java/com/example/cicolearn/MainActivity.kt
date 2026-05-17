package com.example.cicolearn

import android.annotation.SuppressLint
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.ui.theme.CICOLearnTheme
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightBottomNavigationLightText
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightLightText
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient
import com.example.cicolearn.ui.theme.LightSecondary
import com.example.cicolearn.ui.theme.LightSurface

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CICOLearnTheme {
                Scaffold(
                    containerColor = LightBackground,
                    topBar = {
                        TopAppBarHomepage()
                    },
                    bottomBar = {
                        BottomAppBarHomepage()
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
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarHomepage() {
    var input by rememberSaveable { mutableStateOf("") }
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = LightBackground
        ),
        title = {
            BasicTextField(
                value = input,
                onValueChange = { input = it },
                singleLine = false,
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 24.sp
                ),
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .background(color = LightSecondary, RoundedCornerShape(4.dp))
                    .border(1.dp, LightDarkBorder, RoundedCornerShape(4.dp)),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_search),
                            contentDescription = null
                        )
                        Spacer(Modifier.width(16.dp))
                        Box {
                            if (input.isEmpty()){
                                Text(
                                    text = "Search words, phrases...",
                                    color = LightDarkText,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        lineHeight = 24.sp
                                    )
                                )
                            }
                            innerTextField()
                        }
                    }
                }
            )
        },
        actions = {
            Surface(
                modifier = Modifier.size(44.dp),
                color = Color.Transparent
            ) {
                IconButton (
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_top_app_bar_notification), contentDescription = null
                    )
                }
            }
        },
    )
}

@Composable
fun BottomAppBarHomepage() {
    BottomAppBar (
        modifier = Modifier.border(width = 1.dp, color = LightLightBorder),
        containerColor = LightBackground
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 4.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BottomAppBarSelectedItem(iconRes = R.drawable.ic_bottom_app_bar_selected_homepage, itemName = "Homepage")
            BottomAppBarUnselectedItem(iconRes = R.drawable.ic_bottom_app_bar_unselected_memorize, itemName = "Memorize")
            BottomAppBarUnselectedItem(iconRes = R.drawable.ic_bottom_app_bar_unselected_train_with_ai, itemName = "Train with AI")
            BottomAppBarUnselectedItem(iconRes = R.drawable.ic_bottom_app_bar_unselected_profile, itemName = "Profile")
        }
    }
}

@Composable
fun BottomAppBarSelectedItem(
    @DrawableRes iconRes: Int, itemName: String
) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Surface(
            color = LightPrimary,
            shape = RoundedCornerShape(8.dp)
        ) {
            Icon(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .background(color = LightPrimary),
                painter = painterResource(iconRes),
                contentDescription = null,
                tint = LightOnPrimary
            )
        }
        Spacer(Modifier.height(4.dp))
        Text(
            itemName,
            color = LightDarkText,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp
        )
    }
}

@Composable
fun BottomAppBarUnselectedItem(
    @DrawableRes iconRes: Int, itemName: String
) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Icon(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            painter = painterResource(iconRes),
            contentDescription = null
        )
        Spacer(Modifier.height(4.dp))
        Text(
            itemName,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = LightBottomNavigationLightText,
        )
    }
}
@Composable
fun UnselectedLessonCategoryButton(title: String) {
    Button(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        onClick = {},
        colors = ButtonColors(
            containerColor = LightSecondary,
            contentColor = LightDarkText,
            disabledContentColor = Color.Green,
            disabledContainerColor = Color.Yellow
        ),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, LightDarkBorder)
    ) {
        Text(title)
    }
}

@Composable
fun StreakCard() {
    ElevatedCard(
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.Transparent,
            contentColor = LightOnPrimary
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier .fillMaxWidth()
                .background(
                    brush = LightPrimaryGradient,
                    shape = RoundedCornerShape(16.dp)
                ).padding(horizontal = 24.dp, vertical = 24.dp)
        ) {
            Column {
                Text("Streak", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("3 days")
                    Text("121 lessons")
                }
                Spacer(Modifier.height(24.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(painter = painterResource(R.drawable.streak_fire_off), contentDescription = null)
                    Icon(painter = painterResource(R.drawable.streak_fire_off), contentDescription = null)
                    Icon(painter = painterResource(R.drawable.streak_fire_off), contentDescription = null)
                    Icon(painter = painterResource(R.drawable.streak_fire_off), contentDescription = null)
                    Icon(painter = painterResource(R.drawable.streak_fire_off), contentDescription = null)
                    Icon(painter = painterResource(R.drawable.streak_fire_off), contentDescription = null)
                    Icon(painter = painterResource(R.drawable.streak_fire_off), contentDescription = null)
                }
            }
        }
    }
}

@Composable
fun SelectedLessonCategoryButton(title: String) {
    Button(
        contentPadding = PaddingValues(),
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(4.dp),
    ) {
        Box(
            modifier = Modifier
                .background(brush = LightPrimaryGradient, shape = RoundedCornerShape(4.dp))
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(title)
        }
    }
}

@Composable
fun FilterSelectedCategoryLessonDropDownButton(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.background(LightSecondary),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, LightDarkBorder),
        contentColor = LightDarkText
    ) {
        Row(
            modifier = Modifier
                .background(LightSecondary)
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Selected", fontWeight = FontWeight.Medium, fontSize = 14.sp)
            Icon(painter = painterResource(R.drawable.ic_category_lesson_filter), contentDescription = null)
        }
    }
}

@Composable
fun LessonCard(title: String, total: Int, progress: Int) {
    Card(
        colors = CardColors(
            containerColor = LightSurface,
            contentColor = LightLightText,
            disabledContentColor = Color.Green,
            disabledContainerColor = Color.Yellow
        ),
        border = BorderStroke(1.dp, color = LightLightBorder),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(vertical = 24.dp, horizontal = 24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
            ) {
                Image(
                    modifier = Modifier.size(48.dp).clip(RoundedCornerShape(6.dp)),
                    painter = painterResource(R.drawable.introduction_image),
                    contentDescription = null
                )
                Spacer(Modifier.width(16.dp))
                Column(
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Foods",
                        color = LightDarkText,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = "$total Words",
                        modifier = Modifier
                            .background(color = LightPrimary, shape = RoundedCornerShape(999.dp))
                            .padding(horizontal = 8.dp),
                        color = LightOnPrimary,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Spacer(Modifier.weight(1f))
                Icon(
                    painter = painterResource(R.drawable.ic_expand_more),
                    contentDescription = null,
                    Modifier.size(12.dp)
                )
            }
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Progress", fontSize = 13.sp, fontWeight = FontWeight.Medium)
                Text("$progress%", fontSize = 13.sp, fontWeight = FontWeight.Medium)
            }
            Spacer(Modifier.height(4.dp))
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                progress = {0.7f},
                color = LightPrimary,
                trackColor = LightLightBorder,
                drawStopIndicator = {}
            )
        }
    }
}
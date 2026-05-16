package com.example.cicolearn

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.ui.theme.CICOLearnTheme
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder
import com.example.cicolearn.ui.theme.LightLightText
import com.example.cicolearn.ui.theme.LightOnPrimary
import com.example.cicolearn.ui.theme.LightPrimary
import com.example.cicolearn.ui.theme.LightPrimaryGradient
import com.example.cicolearn.ui.theme.LightSecondary

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
//                            .background(color = Color.Red)
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(Modifier.height(8.dp))
                        Row(
                        ) {
                            Text(String(Character.toChars(128536)), fontSize = 32.sp)
                            Spacer(Modifier.width(16.dp))
                            Text("Hello ..! Mumpung otak masih fresh nih, mau belajar apa?", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = LightDarkText)
                        }
                        Spacer(Modifier.height(16.dp))
                        ElevatedCard(
                            colors = CardColors(
                                containerColor = LightPrimary,
                                contentColor = LightOnPrimary,
                                disabledContentColor = Color.Green,
                                disabledContainerColor = Color.Yellow
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp)
                            ) {
                                Text("Streak", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("3 days")
                                    Text("121 lessons")
                                }
                                Spacer(Modifier.height(16.dp))
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
                        Spacer(Modifier.height(16.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth().horizontalScroll(scrollLessonsCategoryState),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),

                        ) {
                            SelectedLessonCategoryButton("Recent Lessons")
                            UnselectedLessonCategoryButton("Vocabulary")
                            UnselectedLessonCategoryButton("Grammar")
                            UnselectedLessonCategoryButton("Dialog")
                        }
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
                modifier = Modifier
                    .background(color = LightSecondary)
                    .fillMaxWidth(1f)
                    .padding(end = 8.dp)
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
                        if (input.isEmpty()){
                            input = "Search words, phrases..."
                        }
                        innerTextField()
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
            BottomAppBarHomepageItem(iconRes = R.drawable.ic_bottom_app_bar_selected_homepage, itemName = "Homepage")
            BottomAppBarHomepageItem(iconRes = R.drawable.ic_bottom_app_bar_selected_memorize, itemName = "Memorize")
            BottomAppBarHomepageItem(iconRes = R.drawable.ic_bottom_app_bar_selected_train_with_ai, itemName = "Train with AI")
            BottomAppBarHomepageItem(iconRes = R.drawable.ic_bottom_app_bar_selected_profile, itemName = "Profile")
        }
    }
}

@Composable
fun BottomAppBarHomepageItem(
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
                contentDescription = null
            )
        }
        Spacer(Modifier.height(4.dp))
        Text(
            itemName,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp
        )
    }
}

@Composable
fun UnselectedLessonCategoryButton(title: String) {
    Button(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
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
fun SelectedLessonCategoryButton(title: String) {
    Button(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        onClick = {},
        colors = ButtonColors(
            containerColor = LightPrimary,
            contentColor = LightOnPrimary,
            disabledContentColor = Color.Green,
            disabledContainerColor = Color.Yellow
        ),
        shape = RoundedCornerShape(4.dp),
    ) {
        Text(title)
    }
}

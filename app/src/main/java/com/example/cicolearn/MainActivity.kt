package com.example.cicolearn

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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

data class TabBarItem(
    val title: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
)

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val homepageTab = TabBarItem(title = "Home", selectedIcon = R.drawable.ic_bottom_app_bar_selected_homepage, unselectedIcon = R.drawable.ic_bottom_app_bar_unselected_homepage)
            val memorizeTab = TabBarItem(title = "Memorize", selectedIcon = R.drawable.ic_bottom_app_bar_selected_memorize, unselectedIcon = R.drawable.ic_bottom_app_bar_unselected_memorize)
            val trainWithAITab = TabBarItem(title = "Train with AI", selectedIcon = R.drawable.ic_bottom_app_bar_selected_train_with_ai, unselectedIcon = R.drawable.ic_bottom_app_bar_unselected_memorize)
            val profileTab = TabBarItem(title = "Profile", selectedIcon = R.drawable.ic_bottom_app_bar_selected_profile, unselectedIcon = R.drawable.ic_bottom_app_bar_unselected_profile)

            val tabBarItems = listOf<TabBarItem>(homepageTab, memorizeTab, trainWithAITab, profileTab)

            val navController = rememberNavController()
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

            val showBottomBar = currentRoute in listOf(
                "Home", "Memorize", "Train with AI", "Profile", "Notification"
            )

            CICOLearnTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = LightBackground
                ) {
                    Scaffold(
                        bottomBar = {
                            if (showBottomBar) {
                                TabView(tabBarItems, navController)
                            }
                        }
                    ) {
                        NavHost(navController = navController, startDestination = homepageTab.title) {
                            composable(homepageTab.title) { HomeScreen(navController = navController) }
                            composable(memorizeTab.title) { Text(memorizeTab.title) }
                            composable(trainWithAITab.title) { Text(trainWithAITab.title) }
                            composable(profileTab.title) { Text(profileTab.title) }
                            composable("Notification") { NotificationScreen(navController = navController) }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TabView(tabBarItem: List<TabBarItem>, navController: NavController) {
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar {
        tabBarItem.forEachIndexed { index,tabBarItem ->
            NavigationBarItem(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    navController.navigate(tabBarItem.title)
                },
                icon = {
                    TabBarIconView(
                        isSelected = selectedTabIndex == index,
                        selectedIcon = tabBarItem.selectedIcon,
                        unselectedIcon = tabBarItem.unselectedIcon,
                        title = tabBarItem.title
                    )
                },
                label = {
                    Text(
                        text = tabBarItem.title,
                        color = if (selectedTabIndex == index) { LightDarkText } else { LightBottomNavigationLightText }
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Transparent,
                    unselectedIconColor = Color.Transparent,
                    indicatorColor = Color.Transparent,
                    selectedTextColor = LightDarkText,
                    unselectedTextColor = LightBottomNavigationLightText
                ),
            )
        }
    }
}

@Composable
fun TabBarIconView(
    isSelected: Boolean,
    @DrawableRes selectedIcon: Int,
    @DrawableRes unselectedIcon: Int,
    title: String,
) {
    if (isSelected) {
        Surface(
            color = LightPrimary,
            shape = RoundedCornerShape(8.dp)
        ) {
            Icon(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .background(color = LightPrimary),
                painter = painterResource(selectedIcon),
                contentDescription = title,
                tint = LightOnPrimary
            )
        }
    } else {
        Icon(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            painter = painterResource(unselectedIcon),
            contentDescription = null,
            tint = LightDarkText
        )
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        containerColor = LightBackground,
        topBar = {
            TopAppBarHome(navController = navController)
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

@Composable
fun NotificationItem(title : String, text : String, timeDistace: String) {
    HorizontalDivider(thickness = 1.dp, color = LightLightBorder)
    Row (
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(String(Character.toChars(128536)), fontSize = 40.sp)
        Spacer(Modifier.width(16.dp))
        Column(
        ) {
            Text(title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = LightDarkText)
            Spacer(Modifier.height(4.dp))
            Text(
                text,
                fontSize = 14.sp,
                color = LightDarkText,
                fontWeight = FontWeight.W400,
                lineHeight = 16.sp
            )
            Spacer(Modifier.height(4.dp))
            Text("$timeDistace ago", fontSize = 12.sp, color = LightLightText, fontWeight = FontWeight.Normal)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarHome(navController: NavController) {
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
                    onClick = {
                        navController.navigate("Notification")
                    }
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
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = LightPrimaryGradient,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 24.dp, vertical = 24.dp)
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
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(6.dp)),
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
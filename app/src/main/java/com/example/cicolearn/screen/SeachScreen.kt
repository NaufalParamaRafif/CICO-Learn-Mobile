package com.example.cicolearn.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cicolearn.R
import com.example.cicolearn.components.LessonCard
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightSecondary
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController, placeholderText: String) {
    Scaffold(
        topBar = {
            val inputState = rememberTextFieldState()
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
                    OutlinedTextField(
                        modifier = Modifier
                            .background(LightSecondary)
                            .border(1.dp, LightDarkBorder, shape = RoundedCornerShape(4.dp))
                            .fillMaxWidth()
                            .heightIn(min = 48.dp),
                        state = inputState,
                        shape = RoundedCornerShape(4.dp),
                        leadingIcon = { Icon(painter = painterResource(R.drawable.ic_search), contentDescription = null) },
                        placeholder = {
                            Text(placeholderText, fontSize = 14.sp)
                        },
                        trailingIcon = {
                            Icon(
                                painterResource(R.drawable.ic_close),
                                contentDescription = null,
                                modifier = Modifier
//                            .background(Color.Red)
                                    .padding(8.dp)
                                    .alpha(if (inputState.text.isEmpty()) 0f else 1f)
                                    .clickable {
                                        inputState.clearText()
                                    }
                            )
                        },
                        lineLimits = TextFieldLineLimits.SingleLine,
                        contentPadding = PaddingValues(0.dp),
                        textStyle = TextStyle(
                            color = LightDarkText,
                            fontSize = 14.sp,
                        ),
                    )
                },
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding)
        ) {
            LessonCard(
                title = "Foods", 12, 123
            )
        }
    }
}

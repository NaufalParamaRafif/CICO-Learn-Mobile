package com.example.cicolearn.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cicolearn.R
import com.example.cicolearn.graphs.HomeDetailsScreen
import com.example.cicolearn.ui.theme.LightBackground
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSearch(
    navController: NavHostController,
    @DrawableRes actionIcon: Int,
    actionDestinationRoute: String,
    placeHolderText : String
) {
    val inputState = rememberTextFieldState()
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsFocusedAsState()

    if (isPressed) {
        navController.navigate(HomeDetailsScreen.Search.route)
    }

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = LightBackground
        ),
        title = {
            OutlinedTextField(
                modifier = Modifier
                    .background(LightSecondary)
                    .border(1.dp, LightDarkBorder, shape = RoundedCornerShape(4.dp))
                    .fillMaxWidth()
                    .heightIn(min = 48.dp),
                state = inputState,
                readOnly = true,
                interactionSource = interactionSource,
                shape = RoundedCornerShape(4.dp),
                leadingIcon = { Icon(painter = painterResource(R.drawable.ic_search), contentDescription = null) },
                placeholder = {
                    Text(placeHolderText, fontSize = 14.sp)
                },
                trailingIcon = {
                    Icon(
                        painterResource(R.drawable.ic_close),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .alpha(if (inputState.text.isEmpty()) 0f else 1f)
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
        actions = {
            Spacer(Modifier.width(8.dp))
            Surface(
                modifier = Modifier
                    .size(44.dp)
                    .fillMaxWidth(1f),
                color = Color.Transparent
            ) {
                IconButton (
                    onClick = {
                        navController.navigate(route = actionDestinationRoute)
                    }
                ) {
                    Icon(
                        painter = painterResource(actionIcon), contentDescription = null
                    )
                }
            }
            Spacer(Modifier.width(8.dp))
        },
    )
}

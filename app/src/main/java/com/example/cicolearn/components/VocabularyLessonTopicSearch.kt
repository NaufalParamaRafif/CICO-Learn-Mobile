package com.example.cicolearn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.R
import com.example.cicolearn.ui.theme.LightSecondary

@Composable
fun VocabularyLessonTopicSearch() {
    OutlinedTextField(
        modifier = Modifier.height(40.dp).background(LightSecondary).fillMaxWidth(),
        state = rememberTextFieldState(),
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = null
            )
        },
        trailingIcon = {
            Box(
                modifier = Modifier.size(44.dp),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_close),
                    modifier = Modifier.size(20.dp),
                    contentDescription = null,
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
        ),
        lineLimits = TextFieldLineLimits.SingleLine,
        placeholder = {
            Text("Search Words", fontSize = 12.sp)
        },
        contentPadding = PaddingValues(horizontal = 12.dp)
    )
}
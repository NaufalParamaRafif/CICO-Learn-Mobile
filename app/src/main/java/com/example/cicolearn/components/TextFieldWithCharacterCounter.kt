package com.example.cicolearn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldDecorator
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBackground

@Composable
fun TextFieldWithCharacterCounter(maxChar: Int) {
    val basicTextFieldState = rememberTextFieldState()
    val countText = basicTextFieldState.text.length.toString()

    BasicTextField(
        modifier = Modifier
            .background(LightLightBackground)
            .fillMaxWidth()
            .border(0.8.dp, LightDarkBorder, RoundedCornerShape(4.dp)),
        state = basicTextFieldState,
        textStyle = TextStyle(
            color = LightDarkText,
            fontSize = 14.sp,
        ),
        decorator = TextFieldDecorator { innerTextField ->
            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Box {
                    innerTextField()
                    if (basicTextFieldState.text.isEmpty()) {
                        Text("Type Here", fontSize = 14.sp,  color = LightDarkText.copy(0.35f))
                    }
                }

                Spacer(Modifier.height(8.dp))

                Text(text = "$countText/$maxChar", fontSize = 14.sp,  color = LightDarkText.copy(0.35f), modifier = Modifier.align(Alignment.End))
            }
        }
    )
}
package com.example.cicolearn

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.graphics.pdf.content.PdfPageGotoLinkContent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cicolearn.ui.theme.CICOLearnTheme
import com.example.cicolearn.ui.theme.LightDarkBorder
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightSecondary
import com.example.cicolearn.ui.theme.Lightbackground
import com.example.cicolearn.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CICOLearnTheme {
                Scaffold(
                    topBar = {
                        TopAppBarHomepage()
                    },
                    modifier = Modifier.fillMaxWidth().background(color = Lightbackground)
                ) {
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
        title = {
            BasicTextField(
                value = input,
                onValueChange = { input = it },
                singleLine = false,
                modifier = Modifier
                    .background(color = LightSecondary)
                    .fillMaxWidth()
                    .border(1.dp, LightDarkBorder, RoundedCornerShape(4.dp)),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.width(16.dp),
                            painter = painterResource(R.drawable.ic_top_app_bar_search),
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
            IconButton (
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_top_app_bar_notification), contentDescription = null
                )
            }
        },
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBarHomepage()
}

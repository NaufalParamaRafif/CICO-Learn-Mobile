package com.example.cicolearn

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cicolearn.ui.theme.CICOLearnTheme

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
                        TopAppBar(
                            title = {
                                TextField(
                                    state = rememberTextFieldState(initialText = ""),
                                    label = { Text("Search") },
                                    leadingIcon = { Icon(painter = painterResource(R.drawable.ic_top_app_bar_search), contentDescription = null) },
                                    placeholder = { Text("Search words, phrases...") },
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
                            }
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                }
            }
        }
    }
}

package com.example.cicolearn.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cicolearn.R
import com.example.cicolearn.ui.theme.LightDarkText
import com.example.cicolearn.ui.theme.LightLightBorder

@Composable
fun OptionProfileItem(
    @DrawableRes icon: Int,
    title: String,
    optionalDescription: String? = null,
    optionalColor: Color? = null,
    showExpandMoreIcon: Boolean = true
) {
    val color = if (optionalColor != null)  optionalColor else LightDarkText
    Row(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(painter = painterResource(icon), contentDescription = null, tint = color)
        Spacer(Modifier.width(8.dp))
        Text(title, modifier = Modifier.weight(1f), color = color, fontWeight = FontWeight.Bold)
        if(!optionalDescription.isNullOrEmpty()) {
            Text(optionalDescription, modifier = Modifier.weight(1f), textAlign = TextAlign.Right)
        }
        Spacer(Modifier.width(8.dp))
        if (showExpandMoreIcon) {
            Icon(painter = painterResource(R.drawable.ic_expand_more), contentDescription = null, modifier = Modifier.size(12.dp))
        }
    }
    HorizontalDivider(modifier = Modifier.padding(horizontal = 12.dp), thickness = 1.dp, color = LightLightBorder)
}
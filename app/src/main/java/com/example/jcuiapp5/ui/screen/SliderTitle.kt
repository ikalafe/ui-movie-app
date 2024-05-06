package com.example.jcuiapp5.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jcuiapp5.R
import com.example.jcuiapp5.ui.theme.AppMenuGray
import com.example.jcuiapp5.ui.theme.AppRed


@Composable
fun SliderTitle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(50.dp)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Available Now", fontSize = 14.sp, color = AppMenuGray)
            Text(text = "Watch Joker", fontSize = 21.sp, color = Color.White)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_play_circle_24),
                contentDescription = "Play",
                modifier = Modifier.size(50.dp),
                tint = AppRed
            )
        }
    }
}

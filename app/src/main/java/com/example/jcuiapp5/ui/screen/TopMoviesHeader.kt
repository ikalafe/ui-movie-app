package com.example.jcuiapp5.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jcuiapp5.ui.theme.AppGray
import com.example.jcuiapp5.ui.theme.AppWhite


@Composable
fun TopMoviesHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp, 25.dp, 25.dp, 10.dp)
    ) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Top Movies",
                color = AppWhite,
                fontSize = 21.sp,
                modifier = Modifier.weight(1f)
            )
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "View All", color = AppGray, fontSize = 14.sp)
            }
        }
    }
}
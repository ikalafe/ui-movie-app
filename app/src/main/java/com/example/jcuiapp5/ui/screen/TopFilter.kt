package com.example.jcuiapp5.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jcuiapp5.ui.theme.PurpleGrey40


@Composable
fun TopFilter(filters: List<String>) {
    var selectedFilter by remember { mutableStateOf(0) }
    LazyRow {
        item {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }
        }
        items(filters.size) {
            TextButton(onClick = { selectedFilter = it }) {
                Text(
                    text = filters[it],
                    color = Color.White,
                    modifier = Modifier
                        .clip(RoundedCornerShape(40))
                        .background(if (selectedFilter == it) PurpleGrey40 else Color.Transparent)
                        .padding(15.dp, 10.dp)
                )
            }
        }
    }
}

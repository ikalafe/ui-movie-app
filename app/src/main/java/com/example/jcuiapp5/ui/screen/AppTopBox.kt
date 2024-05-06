package com.example.jcuiapp5.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jcuiapp5.ui.theme.AppDark


@Composable
fun AppTopBox(
    sliderHeight: Dp,
    filters: List<String>
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(sliderHeight)
    )
    {
        TopSlider(sliderHeight)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(sliderHeight)
                .background(Brush.verticalGradient(listOf(Color.Transparent, AppDark)))
                .align(Alignment.BottomCenter)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
                .align(Alignment.TopCenter)
        )
        {
            TopFilter(filters)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
        {
            SliderTitle()
        }
    }
}

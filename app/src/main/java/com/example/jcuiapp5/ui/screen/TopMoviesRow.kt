package com.example.jcuiapp5.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jcuiapp5.R
import com.example.jcuiapp5.models.Movie
import com.example.jcuiapp5.ui.theme.AppGold
import com.example.jcuiapp5.ui.theme.AppGray
import com.example.jcuiapp5.ui.theme.AppWhite


@Composable
fun TopMoviesRow(movies: List<Movie>) {
    LazyRow(
        contentPadding = PaddingValues(25.dp, 0.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(movies.size) {
            val movie = movies[it]
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(230.dp)
                    .clip(RoundedCornerShape(15.dp)),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(15.dp))
                ) {
                    Image(
                        painter = painterResource(id = movie.image),
                        contentDescription = "Movie",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier
                            .background(AppGray)
                            .padding(3.dp)
                            .align(Alignment.TopStart)
                    ) {
                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_star_24),
                                contentDescription = "Rank",
                                tint = AppGold,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(2.dp))
                            Text(text = movie.rank.toString(), color = AppWhite)
                        }
                    }
                }
            }
        }
    }
}

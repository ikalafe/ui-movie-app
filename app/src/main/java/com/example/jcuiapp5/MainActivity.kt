package com.example.jcuiapp5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jcuiapp5.data.MenuItems
import com.example.jcuiapp5.models.Movie
import com.example.jcuiapp5.ui.screen.AppTopBox
import com.example.jcuiapp5.ui.screen.TopMoviesHeader
import com.example.jcuiapp5.ui.screen.TopMoviesRow
import com.example.jcuiapp5.ui.theme.AppDark
import com.example.jcuiapp5.ui.theme.AppLightGray
import com.example.jcuiapp5.ui.theme.AppMenuGray
import com.example.jcuiapp5.ui.theme.AppRed
import com.example.jcuiapp5.ui.theme.JCUIApp5Theme
import dev.chrisbanes.snapper.ExperimentalSnapperApi

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCUIApp5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainView()
                }
            }
        }
    }
}

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun MainView() {
    val sliderHeight = 340.dp
    val filters = listOf("Movies", "TV Show", "Trailers")
    val movies = listOf(
        Movie(R.drawable.movie_1, 9.4f),
        Movie(R.drawable.movie_2, 8.4f),
        Movie(R.drawable.movie_3, 9.3f),
        Movie(R.drawable.movie_4, 10.0f),
        Movie(R.drawable.movie_5, 8.9f),
        Movie(R.drawable.movie_6, 9.7f),
        Movie(R.drawable.movie_7, 8.4f),
    )
    val bottomMenuList =
        listOf(MenuItems.Home, MenuItems.Movies, MenuItems.Favorites, MenuItems.Profile)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppDark)
    )
    {
        Column(modifier = Modifier.fillMaxSize()) {
            AppTopBox(sliderHeight, filters)
            Spacer(modifier = Modifier.height(10.dp))
            TopMoviesHeader()
            TopMoviesRow(movies)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .clip(RoundedCornerShape(50, 50, 0, 0))
                .align(Alignment.BottomCenter)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppLightGray)
            )
            {
                var selectedMenu by remember { mutableStateOf(0) }
                LazyRow(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(25.dp, 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    items(bottomMenuList.size) {
                        val menu = bottomMenuList[it]
                        IconButton(
                            onClick = { selectedMenu = it }, modifier = Modifier.clip(RoundedCornerShape(50.dp))
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(if (selectedMenu == it) AppRed else Color.Transparent)
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = menu.icon),
                                    contentDescription = menu.title,
                                    tint = if (selectedMenu == it) Color.White else AppMenuGray,
                                    modifier = Modifier.size(25.dp)
                                )
                                Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
                                if (selectedMenu == it)
                                    Text(text = menu.title, fontSize = 14.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JCUIApp5Theme {
        MainView()
    }
}
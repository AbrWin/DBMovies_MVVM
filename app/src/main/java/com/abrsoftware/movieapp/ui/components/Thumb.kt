package com.abrsoftware.movieapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.abrsoftware.movieapp.R
import com.abrsoftware.movieapp.domain.dbmovie.Movie


@Composable
fun Thumb(item: Movie, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(200.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            model = ImageRequest.Builder(LocalContext.current)
                .data(LocalContext.current.getString(R.string.img_end_point) + item.poster_path)
                .crossfade(500)
                .build(),
            contentDescription = "baseImage",
            contentScale = ContentScale.Crop
        )
    }
}
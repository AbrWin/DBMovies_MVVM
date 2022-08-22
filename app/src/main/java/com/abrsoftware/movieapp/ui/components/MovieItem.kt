package com.abrsoftware.movieapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abrsoftware.movieapp.domain.dbmovie.Movie
import com.abrsoftware.movieapp.ui.theme.BlackL100
import com.abrsoftware.movieapp.ui.theme.PersonalStyle

@Composable
fun MovieItem(
    item: Movie
) {
    Card(
        modifier = Modifier
            .width(200.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(16.dp),
    ) {
        Column {
            Thumb(item = item)
            Title(item = item)
        }
    }
}

@Composable
private fun Title(item: Movie) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = item.title,
            style = PersonalStyle(Color.Black).copy(fontSize = 16.sp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
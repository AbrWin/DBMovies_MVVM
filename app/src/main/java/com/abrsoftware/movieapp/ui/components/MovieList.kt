package com.abrsoftware.movieapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abrsoftware.movieapp.R
import com.abrsoftware.movieapp.domain.dbmovie.Movie

@Composable
fun MediaList(
    movies: List<Movie>
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_16)),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        items(movies){movie->
            MovieItem(
                item = movie
            )
        }
    }
}

@Preview
@Composable
fun PrevMovie() {

}
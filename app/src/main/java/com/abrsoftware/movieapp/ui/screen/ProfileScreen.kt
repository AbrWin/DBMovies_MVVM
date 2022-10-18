package com.abrsoftware.movieapp.ui.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.asFlow
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.withStateAtLeast
import com.abrsoftware.movieapp.domain.dbmovie.Account
import com.abrsoftware.movieapp.domain.dbmovie.Movie
import com.abrsoftware.movieapp.ui.components.MediaList
import com.abrsoftware.movieapp.ui.components.ProfileComponent
import com.abrsoftware.movieapp.ui.viewmodel.DBMovieViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch


@SuppressLint("UnrememberedMutableState")
@Composable
fun ProfileScreen(
    account: Account,
    viewModel: DBMovieViewModel = hiltViewModel(),
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Column {
            ProfileComponent(account)
            MediaList(movies = viewModel.movieListResponse.collectAsState().value)
            viewModel.getListMovies()
        }
    }
}

@Composable
fun Container( content: @Composable() () -> Unit ) {
    content()
}

@Composable
fun SetList(movies: List<Movie>) {
    MediaList(movies)
}

@Preview(
    showBackground = true,
    name = "Android Button text",
    device = Devices.PIXEL_4
)
@Composable
fun PrevProfile() {

}
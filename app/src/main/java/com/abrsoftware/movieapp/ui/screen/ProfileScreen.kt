package com.abrsoftware.movieapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrsoftware.movieapp.domain.dbmovie.Account
import com.abrsoftware.movieapp.domain.dbmovie.Movie
import com.abrsoftware.movieapp.findActivity
import com.abrsoftware.movieapp.ui.components.MediaList
import com.abrsoftware.movieapp.ui.components.ProfileComponent
import com.abrsoftware.movieapp.ui.viewmodel.DBMovieViewModel


@SuppressLint("UnrememberedMutableState")
@Composable
fun ProfileScreen(
    account: Account,
    viewModel: DBMovieViewModel = hiltViewModel()
) {
    val activity = LocalContext.current.findActivity()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val movies by viewModel.movieList.collectAsStateWithLifecycle()

        Column {
            ProfileComponent(account)
            MediaList(movies = movies)
            LaunchedEffect(activity!!.lifecycle){
                activity.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.getListMovies()
                }
            }
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
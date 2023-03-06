package com.abrsoftware.movieapp.ui.screen

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle

import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.abrsoftware.movieapp.MainActivity
import com.abrsoftware.movieapp.ui.components.InputText
import com.abrsoftware.movieapp.ui.theme.GreenBase
import com.abrsoftware.movieapp.ui.theme.PersonalStyle
import com.abrsoftware.movieapp.R
import com.abrsoftware.movieapp.domain.dbmovie.Account
import com.abrsoftware.movieapp.ui.components.DialogLoading
import com.abrsoftware.movieapp.ui.components.SnackbarScreen
import com.abrsoftware.movieapp.ui.components.Thumb
import com.abrsoftware.movieapp.ui.viewmodel.DBMovieViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun LoginScreen(
    onNavigate: (account: Account) -> Unit,
    viewModel: DBMovieViewModel = hiltViewModel()
) {
    val account by viewModel.account.collectAsState()
    val scope = rememberCoroutineScope()

    val accountId by remember {
        mutableStateOf(Account())
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        var btnText by remember {
            mutableStateOf("Hi There!")
        }

        var userVal by remember {
            mutableStateOf("")
        }

        var passVal by remember {
            mutableStateOf("")
        }

        Column {

            AsyncImage(
                modifier = Modifier
                    .height(350.dp)
                    .fillMaxWidth()
                    .background(Color.White),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(stringResource(R.string.img_fake))
                    .crossfade(100)
                    .build(),
                contentDescription = "baseImage",
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
                verticalArrangement = Arrangement.Top
            ) {
                InputText("User", onGetText = {
                    userVal = it
                })

                InputText("Password", onGetText = {
                    passVal = it
                })

                Spacer(modifier = Modifier.height(40.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = GreenBase,
                        contentColor = Color.Black
                    ),
                    onClick = {
                        viewModel.initLogin(username = "abrwin21", password = "dante2143")
                    }) {
                    Text(text = btnText)
                }
            }
        }
        Box(
            modifier = Modifier
                .height(350.dp)
                .fillMaxWidth()
                .background(
                    Color.Black.copy(0.5f)
                )
        ) {
            LoginText()
        }

        if (viewModel.errorMsj != "") {
            SnackbarScreen({
                viewModel.errorMsj = ""
            }, message = viewModel.errorMsj)
        }

        if (viewModel.isLoading) {
            btnText = "LOADING.."
            DialogLoading()
        } else {
            btnText = "Hi there!"
            if (account.id != 0) {
                scope.launch {
                    Log.d("id->", account.id.toString())
                    onNavigate(account)
                    scope.cancel()
                }
            }
        }
    }
}

@Composable
fun LoginText() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            text = "App demo for Movies",
            style = PersonalStyle(GreenBase)
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            text = "WELCOME TO \nTHE MOVIE APP",
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                fontFamily = FontFamily.Default,
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            text = "May be you can find great movies in this app!",
            style = PersonalStyle(Color.White)
        )
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Preview(
    showBackground = true,
    name = "Android Button text",
    device = Devices.PIXEL_4
)
@Composable
fun PrevScreen() {
    //LoginScreen()
}
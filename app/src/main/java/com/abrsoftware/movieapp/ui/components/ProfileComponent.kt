package com.abrsoftware.movieapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import com.abrsoftware.movieapp.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.abrsoftware.movieapp.domain.dbmovie.Account
import com.abrsoftware.movieapp.ui.theme.PersonalStyle

@Composable
fun ProfileComponent(
    account: Account
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(26.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .height(150.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Center)
                    .height(270.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    modifier = Modifier
                        .height(140.dp)
                        .width(140.dp)
                        .clip(CircleShape),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(LocalContext.current.getString(R.string.img_end_point) + account.avatar.tmdb.userImg)
                        .crossfade(100)
                        .build(),
                    contentDescription = stringResource(R.string.ctdescription),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = account.name,
                    style = PersonalStyle(Color.Black).copy(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(
                    text = account.username,
                    style = PersonalStyle(Color.Black).copy(
                        fontSize = 20.sp
                    )
                )
            }

            Text(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp),
                text = "Country: " + account.country,
                style = PersonalStyle(Color.Black).copy(
                    fontSize = 14.sp
                )
            )
            Text(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp),
                text = "Number Account: " + account.id,
                style = PersonalStyle(Color.Black).copy(
                    fontSize = 14.sp
                )
            )
        }
    }
}

@Preview(
    showBackground = true,
    name = "Android Button text",
    device = Devices.PIXEL_4
)
@Composable
fun PrevProfile() {

}
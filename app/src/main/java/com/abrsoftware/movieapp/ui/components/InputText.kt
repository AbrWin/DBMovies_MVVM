package com.abrsoftware.movieapp.ui.components

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abrsoftware.movieapp.ui.theme.GreenBase
import com.abrsoftware.movieapp.ui.theme.PersonalStyle


@Composable
fun InputText(placeHolder: String, onGetText: (text: String) -> Unit, mockVal: String) {
    var textState by remember {
        mutableStateOf(mockVal)
    }
    val typeInput = if (!placeHolder.contains("User"))
        PasswordVisualTransformation()
    else {
        VisualTransformation.None
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
    ) {
        TextField(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    Color.White,
                    shape = RoundedCornerShape(8.dp)
                ),
            visualTransformation = typeInput,
            enabled = false,
            value = textState,
            singleLine = true,
            maxLines = 1,
            placeholder = {
                Text(
                    text = placeHolder,
                    style = PersonalStyle(GreenBase).copy(fontSize = 15.sp)
                )
            },
            onValueChange = {
                onGetText(it)
                textState = it
                Log.d("MSJ", textState)
            },

            textStyle = PersonalStyle(GreenBase).copy(fontSize = 15.sp),
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}

@Preview(showBackground = true, heightDp = 400)
@Composable
fun PrevInput() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

    }
}
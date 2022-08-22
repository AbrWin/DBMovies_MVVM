package com.abrsoftware.movieapp.data.model

import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("success") val success: Boolean,
    @SerializedName("expires_at") val expires_at: String,
    @SerializedName("request_token") val request_token: String
)

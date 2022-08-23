package com.abrsoftware.movieapp.data.model

import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("success") val success: Boolean = false,
    @SerializedName("expires_at") val expires_at: String = "",
    @SerializedName("request_token") val request_token: String = "",
    @SerializedName("status_message") val status_message: String = "",
    @SerializedName("status_code") val status_code: Int = 0,
)

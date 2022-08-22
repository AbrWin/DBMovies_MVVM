package com.abrsoftware.movieapp.data.model

import com.google.gson.annotations.SerializedName

data class SessionIdModel(
    @SerializedName("success") val success: Boolean,
    @SerializedName("session_id") val session_id: String
)

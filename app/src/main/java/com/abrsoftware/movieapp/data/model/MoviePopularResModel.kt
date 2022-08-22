package com.abrsoftware.movieapp.data.model

import com.google.gson.annotations.SerializedName

data class MoviePopularResModel(
    @SerializedName("results") val results: List<MovieModel>
)

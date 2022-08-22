package com.abrsoftware.movieapp.data.model

import com.google.gson.annotations.SerializedName

data class AccountModel(
    @SerializedName("avatar") val avatar: Avatar,
    @SerializedName("id") val id: Int,
    @SerializedName("iso_3166_1") val country: String,
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String
)

data class Avatar(
    @SerializedName("tmdb") val tmdb: Tmdb
)

data class Tmdb(
    @SerializedName("avatar_path") val userImg: String
)

data class MovieModel(
    @SerializedName("movieId") val movieId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("release_date") val release_date: String,
    @SerializedName("poster_path") val poster_path: String,
    @SerializedName("overview") val overview: String,
)

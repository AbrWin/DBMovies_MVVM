package com.abrsoftware.movieapp.domain.dbmovie

import android.os.Parcelable
import com.abrsoftware.movieapp.data.model.*
import com.abrsoftware.movieapp.data.model.Avatar
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.RawValue

data class Session(
    val success: Boolean,
    val expires_at: String,
    val request_token: String
){

}

fun SessionModel.toDomain() = Session(success, expires_at, request_token)


data class Login(
    val success: Boolean,
    val expires_at: String,
    val request_token: String,
    val status_message: String,
    val status_code: Int,
)

fun LoginModel.toDomain() = Login(success, expires_at, request_token, status_message, status_code)

data class SessionId(
    val success: Boolean,
    val session_id: String
)

fun SessionIdModel.toDomain() = SessionId(success, session_id)

@Parcelize
data class Account(
    val avatar: @RawValue Avatar,
    val id: Int,
    val country: String,
    val name: String,
    val username: String
): Parcelable


@Parcelize
data class Avatar(
    val tmdb: Tmdb
):Parcelable

@Parcelize
data class Tmdb(
    val userImg: String
):Parcelable

fun AccountModel.toDomain() = Account(avatar, id, country, name, username)



data class Movie(
    val movieId: Int,
    val title: String,
    val release_date: String,
    val poster_path: String,
    val overview: String,
)

fun MovieModel.toDomain() = Movie(movieId, title, release_date, poster_path, overview)

data class MoviePopularResponce(
    val results: List<Movie>
)


fun MoviePopularResModel.toDomain() = MoviePopularResponce(results.map {
    it.toDomain()
})


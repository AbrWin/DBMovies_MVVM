package com.abrsoftware.movieapp.data.network

import com.abrsoftware.movieapp.domain.dbmovie.Session

object Routes {
    const val GET_SESSION = "/3/authentication/token/new?"
    const val AUTHENTICATION = "/3/authentication/token/validate_with_login?"
    const val SESSION_ID = "/3/authentication/session/new?"
    const val ACCOUNT = "/3/account?"
    const val LASTEST = "/3/movie/popular?"
}
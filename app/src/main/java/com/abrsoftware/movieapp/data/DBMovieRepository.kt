package com.abrsoftware.movieapp.data

import com.abrsoftware.movieapp.data.model.*
import com.abrsoftware.movieapp.data.model.MoviePopularResModel
import com.abrsoftware.movieapp.data.network.DBMovieService
import com.abrsoftware.movieapp.domain.dbmovie.*
import javax.inject.Inject

class DBMovieRepository @Inject constructor(
    private val api: DBMovieService
) {
    suspend fun getSession(): Session {
        val response: SessionModel = api.getSession()
        return response.toDomain()
    }

    suspend fun initLogin(username: String, password: String, request_token: String):Login{
        val response: LoginModel = api.initLogin(username, password, request_token)
        return response.toDomain()
    }

    suspend fun getSessionId(request_token: String):SessionId{
        val response: SessionIdModel = api.getSessionId(request_token)
        return response.toDomain()
    }

    suspend fun getAccount(session_id: String):Account{
        val response : AccountModel = api.getAccount(session_id)
        return response.toDomain()
    }

    suspend fun getLastest():List<Movie>{
        val response : MoviePopularResModel = api.getLastest()
        return response.toDomain().results
    }
}
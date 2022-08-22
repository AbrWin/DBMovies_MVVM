package com.abrsoftware.movieapp.domain

import com.abrsoftware.movieapp.data.DBMovieRepository
import com.abrsoftware.movieapp.data.model.SessionModel
import com.abrsoftware.movieapp.domain.dbmovie.*
import javax.inject.Inject

class DBMovieUserCase @Inject constructor(
    private val repository: DBMovieRepository
) {
    suspend fun getSession(): Session {
        return repository.getSession()
    }

    suspend fun initLogin(username: String, password: String, request_token: String): Login {
        return repository.initLogin(
            username = username,
            password = password,
            request_token = request_token
        )
    }

    suspend fun getSessionId(request_token: String): SessionId {
        return repository.getSessionId(
            request_token = request_token
        )
    }

    suspend fun getAccount(session_id:String):Account{
        return repository.getAccount(session_id)
    }

    suspend fun getLastest():List<Movie>{
        return repository.getLastest()
    }

}
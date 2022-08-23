package com.abrsoftware.movieapp.data.network

import android.content.Context
import android.util.Log
import com.abrsoftware.movieapp.R
import com.abrsoftware.movieapp.data.model.*
import com.abrsoftware.movieapp.domain.dbmovie.Login
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class DBMovieService @Inject constructor(
    private val api: DBMovieApiClient,
    @ApplicationContext private val context: Context
) {

    suspend fun getSession(): SessionModel {
        return withContext(Dispatchers.IO) {
            val response = api.getSession(context.getString(R.string.api_key))
            (response.body() as SessionModel)
        }
    }

    suspend fun initLogin(username: String, password: String, request_token: String): LoginModel {
        return withContext(Dispatchers.IO) {
            val response = api.initLogin(
                api_key = context.getString(R.string.api_key),
                username = username,
                password = password,
                request_token = request_token
            )

            try {
                (response.body() as LoginModel)
            } catch (e: Exception) {
                Gson().fromJson(response.errorBody()!!.string(), LoginModel::class.java)
            }
        }
    }

    suspend fun getSessionId(request_token: String): SessionIdModel {
        return withContext(Dispatchers.IO) {
            val response = api.getSessionId(context.getString(R.string.api_key), request_token)
            Log.d("MSJ", response.toString())
            (response.body() as SessionIdModel)
        }
    }

    suspend fun getAccount(session_id: String): AccountModel {
        return withContext(Dispatchers.IO) {
            val response = api.getAccount(context.getString(R.string.api_key), session_id)
            Log.d("MSJ", response.toString())
            (response.body() as AccountModel)
        }
    }

    suspend fun getLastest(): MoviePopularResModel {
        return withContext(Dispatchers.IO) {
            val response = api.getLastest(context.getString(R.string.api_key))
            (response.body() as MoviePopularResModel)
        }
    }
}
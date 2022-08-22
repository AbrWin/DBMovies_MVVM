package com.abrsoftware.movieapp.data.network

import com.abrsoftware.movieapp.data.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DBMovieApiClient {

    @GET(Routes.GET_SESSION)
    suspend fun getSession(
        @Query("api_key") api_key: String?
    ): Response<SessionModel>

    @GET(Routes.AUTHENTICATION)
    suspend fun initLogin(
        @Query("api_key") api_key: String?,
        @Query("username") username: String?,
        @Query("password") password: String?,
        @Query("request_token") request_token: String?
    ): Response<LoginModel>

    @POST(Routes.SESSION_ID)
    suspend fun getSessionId(
        @Query("api_key") api_key: String?,
        @Query("request_token") request_token: String?
    ): Response<SessionIdModel>

    @GET(Routes.ACCOUNT)
    suspend fun getAccount(
        @Query("api_key") api_key: String?,
        @Query("session_id") request_token: String?
    ): Response<AccountModel>

    @GET(Routes.LASTEST)
    suspend fun getLastest(
        @Query("api_key") api_key: String?
    ):  Response<MoviePopularResModel>
}
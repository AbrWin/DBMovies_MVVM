package com.abrsoftware.movieapp.di

import android.content.Context
import com.abrsoftware.movieapp.R
import com.abrsoftware.movieapp.data.network.DBMovieApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providerRetrofit(@ApplicationContext context: Context): Retrofit{
        return Retrofit.Builder()
            .baseUrl(context.getString(R.string.api_end_point))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiClient(retrofit: Retrofit):DBMovieApiClient{
        return retrofit.create(DBMovieApiClient::class.java)
    }

}
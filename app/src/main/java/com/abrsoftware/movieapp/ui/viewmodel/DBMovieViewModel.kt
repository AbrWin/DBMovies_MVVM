package com.abrsoftware.movieapp.ui.viewmodel

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrsoftware.movieapp.domain.DBMovieUserCase
import com.abrsoftware.movieapp.domain.dbmovie.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DBMovieViewModel @Inject constructor(
    private var dBMovieUserCase: DBMovieUserCase
) : ViewModel() {

    val account = MutableLiveData<Account>()
    var isLoading: Boolean by mutableStateOf(false)

    var movieListResponse = MutableStateFlow(emptyList<Movie>())
    var errorMsj: String by mutableStateOf("")

    fun initLogin(username: String, password: String) {
        viewModelScope.launch {
            isLoading = true
            val result = dBMovieUserCase.getSession()
            if (result.success) {
                val resultLogin =
                    dBMovieUserCase.initLogin(username, password, result.request_token)
                if (resultLogin.success) {
                    val resultSessionId = dBMovieUserCase.getSessionId(resultLogin.request_token)
                    if (resultSessionId.session_id.isNotEmpty()) {
                        isLoading = false
                        val resultAccount = dBMovieUserCase.getAccount(resultSessionId.session_id)
                        account.postValue(resultAccount)
                    }
                }else{
                    isLoading = false
                    errorMsj = resultLogin.status_message
                    Log.d("MSJ", resultLogin.status_message)
                }
            }
        }
    }

    fun getListMovies(){
        viewModelScope.launch {
            val result = dBMovieUserCase.getLastest()
            movieListResponse.value = result
        }
    }
}

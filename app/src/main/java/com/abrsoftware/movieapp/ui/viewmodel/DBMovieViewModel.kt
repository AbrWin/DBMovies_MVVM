package com.abrsoftware.movieapp.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrsoftware.movieapp.domain.DBMovieUserCase
import com.abrsoftware.movieapp.domain.dbmovie.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DBMovieViewModel @Inject constructor(
    private var dBMovieUserCase: DBMovieUserCase
) : ViewModel() {

    val _account = MutableStateFlow(Account())
    val account = _account.asStateFlow()

    val _movieList = MutableStateFlow(emptyList<Movie>())
    val movieList = _movieList.asStateFlow()

    var isLoading: Boolean by mutableStateOf(false)
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
                        dBMovieUserCase.getAccount(resultSessionId.session_id).let {
                            _account.value = it
                        }
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
           dBMovieUserCase.getLastest().let {
               _movieList.value = it
           }
        }
    }
}

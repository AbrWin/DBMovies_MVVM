package com.abrsoftware.movieapp.domain

import com.abrsoftware.movieapp.data.DBMovieRepository
import com.abrsoftware.movieapp.domain.dbmovie.Movie
import com.abrsoftware.movieapp.domain.dbmovie.Session
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DBMovieUserCaseTest{

    @RelaxedMockK
    private lateinit var dbMovieRepository : DBMovieRepository
    lateinit var getDBMovieUseCase: DBMovieUserCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getDBMovieUseCase = DBMovieUserCase(dbMovieRepository)
    }

    @Test
    fun whenSessio() = runBlocking {
        //Given
        coEvery{
            dbMovieRepository.getSession()
        } returns Session(false, "", "")

        //when
        getDBMovieUseCase.getSession()
        //Then
        coVerify(exactly = 1) {
            getSession()
        }
    }
}
fun getSession():Session{
    return Session(true, "today", "12345")
}
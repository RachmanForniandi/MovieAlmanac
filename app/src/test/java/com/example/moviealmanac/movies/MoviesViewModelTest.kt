package com.example.moviealmanac.movies

import android.app.Application
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito

class MoviesViewModelTest {

    private lateinit var movieViewModel: MoviesViewModel
    private val application = Mockito.mock(Application::class.java)

    @Before
    fun init() {
        movieViewModel= MoviesViewModel(application)
    }

    @Test
    fun getAllMovies() {
        val testGetDataMovie =movieViewModel.allMovies
        assertNotNull(testGetDataMovie)
        assertEquals(10,testGetDataMovie.size)
    }

}
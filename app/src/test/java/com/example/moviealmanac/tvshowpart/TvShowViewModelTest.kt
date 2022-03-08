package com.example.moviealmanac.tvshowpart

import android.app.Application
import com.example.moviealmanac.movies.MoviesViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito

class TvShowViewModelTest {

    private lateinit var tvShowViewModel: TvShowViewModel
    private val application = Mockito.mock(Application::class.java)


    @Before
    fun init() {
        tvShowViewModel= TvShowViewModel(application)
    }

    @Test
    fun getTvShows() {
        val testGetDataTV= tvShowViewModel.tvShows
        assertNotNull(testGetDataTV)
        assertEquals(10,testGetDataTV.size)
    }


}
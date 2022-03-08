package com.example.moviealmanac.details

import android.app.Application
import com.example.moviealmanac.movies.DataMovies
import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

import org.junit.Before
import org.mockito.Mockito

class MovieDetailViewModelTest {

    private lateinit var viewModel: MovieDetailViewModel
    private val application = Mockito.mock(Application::class.java)
    private val dummyMovie = DataMovies.generateDummyMovie()[0]
    private val movieId = dummyMovie.id

    @Before
    fun setUp() {
        viewModel = MovieDetailViewModel(application)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun setSelectedMovie() {
        viewModel.setSelectedMovie(movieId)
        val entityMovieDetail = viewModel.fetchDetailMovie()
        assertNotNull(entityMovieDetail)
        assertEquals(dummyMovie.id,entityMovieDetail.id)
        assertEquals(dummyMovie.originalLanguage,entityMovieDetail.originalLanguage)
        assertEquals(dummyMovie.overview,entityMovieDetail.overview)
        assertEquals(dummyMovie.title,entityMovieDetail.title)
        assertEquals(dummyMovie.popularity,entityMovieDetail.popularity)
        assertEquals(dummyMovie.voteAverage,entityMovieDetail.voteAverage)


    }

    @Test
    fun fetchDetailMovie() {
        val entityMovieSelected = viewModel.fetchDetailMovie()
        assertNotNull(entityMovieSelected)
        assertEquals(1, listOf(entityMovieSelected).size)
    }
}
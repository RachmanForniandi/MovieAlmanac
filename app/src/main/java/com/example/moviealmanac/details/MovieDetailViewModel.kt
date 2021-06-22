package com.example.moviealmanac.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviealmanac.models.FilmDummy
import com.example.moviealmanac.movies.DataMovies

class MovieDetailViewModel : ViewModel() {
    private var movieId: Int =0

    fun setSelectedCourse(movieId: Int) {
        this.movieId = movieId
    }

    fun fetchDetailMovie(): FilmDummy {
        lateinit var movie: FilmDummy
        val movieContent = DataMovies.generateDummyMovie()
        for (movieTag in movieContent) {
            if (movieTag.id == movieId) {
                movie = movieTag
            }
        }
        return movie
    }


}
package com.example.moviealmanac.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviealmanac.models.FilmDummy
import com.example.moviealmanac.movies.DataMovies

class MovieDetailViewModel(application: Application): AndroidViewModel(application){
    private var movieId: Int =0

    fun setSelectedMovie(movieId: Int) {
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
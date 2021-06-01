package com.example.moviealmanac.movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.moviealmanac.models.FilmDummy

class MoviesViewModel(application: Application): AndroidViewModel(application){

    fun getMovies() :List<FilmDummy> = DataMovies.generateDummyMovie()
    val moviesLoadError by lazy { MutableLiveData<Boolean>() }
    val loading by lazy { MutableLiveData<Boolean>() }

    fun moviesDetail(id:Int):FilmDummy = DataMovies.movieDetail(id)

    fun responseOnGenerateDummyMovie(){

        moviesLoadError.value = false
        loading.value = false

    }
}
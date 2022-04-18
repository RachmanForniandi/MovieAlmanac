package com.example.moviealmanac.movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviealmanac.models.FilmDummy

class MoviesViewModel(application: Application): AndroidViewModel(application){

    val allMovies :List<FilmDummy> = DataMovies.generateDummyMovie()
    val moviesLoadError by lazy { MutableLiveData<Boolean>() }
    val loading by lazy { MutableLiveData<Boolean>() }


    //fun getMovies():LiveData<List<>>
    fun responseOnGenerateDummyMovie(){

        moviesLoadError.value = false
        loading.value = false
    }

}
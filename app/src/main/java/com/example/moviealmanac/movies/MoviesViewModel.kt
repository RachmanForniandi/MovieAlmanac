package com.example.moviealmanac.movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.moviealmanac.models.FilmDummy

class MoviesViewModel(application: Application): AndroidViewModel(application){

    val allMovies :List<FilmDummy> = DataMovies.generateDummyMovie()
    val moviesLoadError by lazy { MutableLiveData<Boolean>() }
    val loading by lazy { MutableLiveData<Boolean>() }




    fun responseOnGenerateDummyMovie(){

        moviesLoadError.value = false
        loading.value = false
    }

    /*fun getMovie():FilmDummy{
        lateinit var film: FilmDummy

        for (filmEntity in allMovies){
            if (filmEntity.id == id)
        }
    }*/
}
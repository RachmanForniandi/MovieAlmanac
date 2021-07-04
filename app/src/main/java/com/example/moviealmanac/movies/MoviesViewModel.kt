package com.example.moviealmanac.movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.moviealmanac.models.FilmDummy

class MoviesViewModel(application: Application): AndroidViewModel(application){

    val allMovies :List<FilmDummy> = DataMovies.generateDummyMovie()
    //val emptyData: MutableLiveData<Boolean> = MutableLiveData(false)
    val moviesLoadError by lazy { MutableLiveData<Boolean>() }
    val loading by lazy { MutableLiveData<Boolean>() }

    //fun moviesDetail(id: Int):FilmDummy = DataMovies.movieDetail(id)



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
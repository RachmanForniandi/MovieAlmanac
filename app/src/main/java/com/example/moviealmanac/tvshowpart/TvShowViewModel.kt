package com.example.moviealmanac.tvshowpart

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.moviealmanac.models.TvShowDummy

class TvShowViewModel (application: Application): AndroidViewModel(application){

    val tvShows:List<TvShowDummy> = DataTvShow.generateDummyTvShow()
    val tvShowsLoadError by lazy { MutableLiveData<Boolean>() }
    val loadingTvShows by lazy { MutableLiveData<Boolean>() }

    fun responseOnGenerateDummyTvShow(){

        tvShowsLoadError.value = false
        loadingTvShows.value = false
    }


}
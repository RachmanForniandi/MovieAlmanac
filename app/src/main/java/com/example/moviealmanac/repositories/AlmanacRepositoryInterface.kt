package com.example.moviealmanac.repositories

import androidx.lifecycle.LiveData
import com.example.moviealmanac.models.movies.MovieResponse
import com.example.moviealmanac.models.tvShows.TvShowResponse
import com.example.moviealmanac.utility.ResourceStatus

interface AlmanacRepositoryInterface {

    suspend fun retrieveDataMovie(apiKey:String): ResourceStatus<MovieResponse>
    suspend fun retrieveDataTvShow(apiKey:String): ResourceStatus<TvShowResponse>
}
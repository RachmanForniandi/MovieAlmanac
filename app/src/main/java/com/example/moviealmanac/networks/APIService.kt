package com.example.moviealmanac.networks

import com.example.moviealmanac.BuildConfig
import com.example.moviealmanac.models.movies.MovieResponse
import com.example.moviealmanac.models.tvShows.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("discover/movie")
    fun getDiscoverMovie(
        @Query(BuildConfig.API_KEY)api_key:String
    ): Call<MovieResponse>

    @GET("discover/tv")
    fun getDiscoverTvShow(
        @Query(BuildConfig.API_KEY)api_key:String
    ): Call<TvShowResponse>
}
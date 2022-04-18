package com.example.moviealmanac.repositories

import com.example.moviealmanac.models.movies.MovieResponse
import com.example.moviealmanac.models.tvShows.TvShowResponse
import com.example.moviealmanac.networks.APIService
import com.example.moviealmanac.utility.ResourceStatus
import java.lang.Exception
import javax.inject.Inject

class AlmanacRepository @Inject constructor (
    private val retrofitApi : APIService):AlmanacRepositoryInterface{

    override suspend fun retrieveDataMovie(apiKey: String): ResourceStatus<MovieResponse> {
        return try {
            val response = retrofitApi.getDiscoverMovie(apiKey)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let ResourceStatus.success(it)
                } ?: ResourceStatus.error("Error",null)
            } else {
                ResourceStatus.error("Error",null)
            }
        }catch (e: Exception) {
            ResourceStatus.error("No data!",null)
        }
    }

    override suspend fun retrieveDataTvShow(apiKey: String): ResourceStatus<TvShowResponse> {
        return try {
            val response = retrofitApi.getDiscoverTvShow(apiKey)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let ResourceStatus.success(it)
                } ?: ResourceStatus.error("Error",null)
            } else {
                ResourceStatus.error("Error",null)
            }
        }catch (e: Exception) {
            ResourceStatus.error("No data!",null)
        }
    }
}
package com.example.moviealmanac.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowDummy (
        val id: Int,
        val name: String,
        val popularity: Double,
        val firstAirDate: String,
        val overview: String,
        val originalLanguage: String,
        val posterPath: String,
        val backdropPath: String,
        val voteAverage: Double
):Parcelable
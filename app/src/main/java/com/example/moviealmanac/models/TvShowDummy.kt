package com.example.moviealmanac.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowDummy (
        val id: Int? = null,
        val name: String? = null,
        val popularity: Double? = null,
        val firstAirDate: String? = null,
        val overview: String? = null,
        val originalLanguage: String? = null,
        val posterPath: String? = null,
        val backdropPath: String? = null,
        val voteAverage: Double? = null
):Parcelable
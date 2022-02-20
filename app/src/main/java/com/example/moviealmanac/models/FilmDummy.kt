package com.example.moviealmanac.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


data class FilmDummy(
        val id: Int ,
        val title: String ,
        val popularity: Double,
        val releaseDate: String ,
        val overview: String ,
        val originalLanguage: String,
        val posterPath: String,
        val backdropPath: String,
        val voteAverage: Double,
)
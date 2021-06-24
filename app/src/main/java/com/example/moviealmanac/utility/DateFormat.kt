package com.example.moviealmanac.utility

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun getStringDate(date: String?): String? {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    val outputDate = SimpleDateFormat("EEE, dd MMM yyy")
    var d: Date? = null
    try {
        d = dateFormat.parse(date)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return outputDate.format(d)
}
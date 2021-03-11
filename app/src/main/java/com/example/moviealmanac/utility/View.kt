package com.example.moviealmanac.utility

import android.view.View
import android.widget.ProgressBar

fun ProgressBar.show(){
    visibility = View.VISIBLE
}

fun ProgressBar.hide(){
    visibility = View.GONE
}
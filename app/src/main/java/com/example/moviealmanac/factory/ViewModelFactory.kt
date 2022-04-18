package com.example.moviealmanac.factory

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.moviealmanac.repositories.AlmanacRepository

class ViewModelFactory private constructor(private val repository: AlmanacRepository): ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        /*fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }*/
    }
}
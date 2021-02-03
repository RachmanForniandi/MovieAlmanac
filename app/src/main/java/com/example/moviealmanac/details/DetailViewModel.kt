package com.example.moviealmanac.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviealmanac.models.FilmDummy

class DetailViewModel : ViewModel() {
    val dummyLiveData = MutableLiveData<FilmDummy>()

    fun fetchDetailData(){
        val exposeDetail =FilmDummy(297802,
            "Aquaman",
            96.117,
            "2019-01-31",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "en",
            "/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
            6.9)

        dummyLiveData.value = exposeDetail
    }
}
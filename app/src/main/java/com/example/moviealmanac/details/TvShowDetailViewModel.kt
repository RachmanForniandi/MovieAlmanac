package com.example.moviealmanac.details

import androidx.lifecycle.ViewModel
import com.example.moviealmanac.models.TvShowDummy
import com.example.moviealmanac.tvshowpart.DataTvShow

class TvShowDetailViewModel : ViewModel() {
    private var tvShowId: Int =0

    fun setSelectedTvShow(tvShowId: Int) {
        this.tvShowId = tvShowId
    }

    fun fetchDetailTvShow(): TvShowDummy {
        lateinit var tv: TvShowDummy
        val tvContent = DataTvShow.generateDummyTvShow()
        for (tvTag in tvContent) {
            if (tvTag.id == tvShowId) {
                tv = tvTag
            }
        }
        return tv
    }
}
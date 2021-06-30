package com.example.moviealmanac.details

import android.app.Application
import com.example.moviealmanac.tvshowpart.DataTvShow
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test

import org.junit.Before
import org.mockito.Mockito

class TvShowDetailViewModelTest {

    private lateinit var viewModel: TvShowDetailViewModel
    private val application = Mockito.mock(Application::class.java)
    private val dummyTv = DataTvShow.generateDummyTvShow()[0]
    private val tvId = dummyTv.id


    @Before
    fun setUp() {
        viewModel = TvShowDetailViewModel(application)
        viewModel.setSelectedTvShow(tvId) 
    }
    @Test
    fun setSelectedTvShow() {
        viewModel.setSelectedTvShow(tvId)
        val entityTvShowDetail = viewModel.fetchDetailTvShow()
        Assert.assertNotNull(entityTvShowDetail)
        TestCase.assertEquals(dummyTv.id, entityTvShowDetail.id)
        TestCase.assertEquals(dummyTv.originalLanguage, entityTvShowDetail.originalLanguage)
        TestCase.assertEquals(dummyTv.overview, entityTvShowDetail.overview)
        TestCase.assertEquals(dummyTv.name, entityTvShowDetail.name)
        TestCase.assertEquals(dummyTv.popularity, entityTvShowDetail.popularity)
        TestCase.assertEquals(dummyTv.voteAverage, entityTvShowDetail.voteAverage)
    }

    @Test
    fun fetchDetailTvShow() {
        val testGetDataTvShow =viewModel.fetchDetailTvShow()
        Assert.assertNotNull(testGetDataTvShow)
        TestCase.assertEquals(1, listOf(testGetDataTvShow).size)
    }


}
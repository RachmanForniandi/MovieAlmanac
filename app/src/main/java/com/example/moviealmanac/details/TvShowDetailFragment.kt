package com.example.moviealmanac.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviealmanac.BuildConfig
import com.example.moviealmanac.R
import com.example.moviealmanac.models.TvShowDummy
import com.example.moviealmanac.utility.getStringDate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_scrolling_tv_show.*
import kotlinx.android.synthetic.main.tv_show_detail_fragment.*

class TvShowDetailFragment : Fragment() {

    companion object {
        fun newInstance() = TvShowDetailFragment()
    }

    private lateinit var viewModel: TvShowDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.tv_show_detail_fragment, container, false)
    }

    /*override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
    }*/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(TvShowDetailViewModel::class.java)

        val id = arguments?.getInt("tvShowId")
        Log.e("keyDetailTv",""+id)

        if (id != null) {
            if (id!=0){
                viewModel.setSelectedTvShow(id)
                loadDetailDataTvShow(viewModel.fetchDetailTvShow()as TvShowDummy)
            }
            Log.e("keyTvUse",""+id)
        }
    }

    private fun loadDetailDataTvShow(tvShowDetail: TvShowDummy) {

        val backDropPathUrl = BuildConfig.BASE_URL_IMAGE_DROP_PATH + tvShowDetail.backdropPath
        Picasso.get()
            .load(backDropPathUrl)
            .placeholder(R.drawable.place_holder)
            .error(R.drawable.place_holder)
            .fit().centerCrop()
            .into(img_back_drop_tv_show)

        val posterPathUrl = BuildConfig.BASE_URL_IMAGE_POSTER_PATH + tvShowDetail.posterPath
        Picasso.get()
            .load(posterPathUrl)
            .placeholder(R.drawable.place_holder)
            .error(R.drawable.place_holder)
            .fit().centerCrop()
            .into(img_poster_detail_tv)
        Log.e("testUrlDetail",""+ tvShowDetail.posterPath)

        val convertVoteAvg =tvShowDetail.voteAverage.toString()
        val valRating = tvShowDetail.voteAverage.div(2.0)
        val valForRateBar= valRating.toString()
        val formatDatePremiere:String = tvShowDetail.firstAirDate.let {  getStringDate(it) }?: "-"


        txt_name_tv_show_detail.text = tvShowDetail.name
        txt_content_overview_tv_show_detail.text = tvShowDetail.overview

        txt_release_date_tv_show_detail.text = formatDatePremiere
        txt_original_language_tv_show_detail.text =tvShowDetail.originalLanguage
        /*if (tvShowDetail.originalLanguage.equals("en")){
            txt_original_language_tv_show_detail.text = "English"
        }else if(tvShowDetail.originalLanguage.equals("ja")){
            txt_original_language_tv_show_detail.text = "Japanese"
        }else if(tvShowDetail.originalLanguage.equals("fr")){
            txt_original_language_tv_show_detail.text = "French"
        }else{
            txt_original_language_tv_show_detail.text = "Unknown Language"
        }*/

        txt_vote_average_detail_tv_show.text = convertVoteAvg
        txt_value_rate_detail_tv_show.text = valForRateBar
        //bar_rating_chart_tv_show_detail.rating = valForRateBar.toFloat()

    }

}
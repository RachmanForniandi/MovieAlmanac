package com.example.moviealmanac.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviealmanac.BuildConfig.BASE_URL_IMAGE_DROP_PATH
import com.example.moviealmanac.BuildConfig.BASE_URL_IMAGE_POSTER_PATH
import com.example.moviealmanac.R
import com.example.moviealmanac.models.FilmDummy
import com.example.moviealmanac.utility.getStringDate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_scrolling_movie.*
import kotlinx.android.synthetic.main.detail_movie_fragment.*


class MovieDetailFragment : Fragment() {



    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.detail_movie_fragment, container, false)
        
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)

        val id = arguments?.getInt("movieId")
        Log.e("keyDetail",""+id)


        if (id != null) {
            if (id!=0){
                viewModel.setSelectedMovie(id)
                loadDetailDataMovie(viewModel.fetchDetailMovie())
            }
            Log.e("keyUse",""+id)
        }
    }

    private fun loadDetailDataMovie(moviesDetail: FilmDummy) {

        val backDropPathUrl = BASE_URL_IMAGE_DROP_PATH + moviesDetail.backdropPath
        Picasso.get()
            .load(backDropPathUrl)
            .placeholder(R.drawable.place_holder)
            .error(R.drawable.place_holder)
            .fit().centerCrop()
            .into(img_back_drop)

        val posterPathUrl = BASE_URL_IMAGE_POSTER_PATH + moviesDetail.posterPath
        Picasso.get()
            .load(posterPathUrl)
            .placeholder(R.drawable.place_holder)
            .error(R.drawable.place_holder)
            .fit().centerCrop()
            .into(img_poster_detail_movie)
        Log.e("testUrlDetail",""+ moviesDetail.posterPath)

        val convertVoteAvg =moviesDetail.voteAverage.toString()
        val valRating = moviesDetail.voteAverage.div(2.0)
        val valForRateBar= valRating.toString()


        txt_title_movie_detail.text = moviesDetail.title
        txt_content_overview_detail_movie.text = moviesDetail.overview

        txt_vote_average_detail_movie.text = convertVoteAvg
        val formatDatePremiere:String = moviesDetail.releaseDate.let {  getStringDate(it) }?: "-"

        txt_release_date_detail_movie.text = formatDatePremiere
        txt_original_language_detail_movie.text = moviesDetail.originalLanguage
        txt_value_rate_detail_movie.text = valForRateBar



    }

    companion object {
        fun newInstance() = MovieDetailFragment()
    }
}
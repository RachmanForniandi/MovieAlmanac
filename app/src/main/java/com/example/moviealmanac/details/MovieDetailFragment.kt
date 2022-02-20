package com.example.moviealmanac.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
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

    companion object {
        fun newInstance() = MovieDetailFragment()
    }

    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.detail_movie_fragment, container, false)
        
    }

    /*override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
    }*/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)

        val id = arguments?.getInt("movieId")
        Log.e("keyDetail",""+id)


        if (id != null) {
            if (id!=0){
                viewModel.setSelectedMovie(id)
                loadDetailDataMovie(viewModel.fetchDetailMovie()as FilmDummy)
            }
            Log.e("keyUse",""+id)
        }
        /*if (id != null) {
            if (id.equals("movieId" to id) && id !=0){
                loadDetailDataMovie(viewModel.moviesDetail(id))
            }
            Log.e("keyUse",""+id)
        }*/
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
            .into(img_poster_detail)
        Log.e("testUrlDetail",""+ moviesDetail.posterPath)

        val convertVoteAvg =moviesDetail.voteAverage.toString()
        val valRating = moviesDetail.voteAverage.div(2.0)
        val valForRateBar= valRating.toString()
        val formatDatePremiere:String = moviesDetail.releaseDate.let {  getStringDate(it) }?: "-"


        txt_title_movie_detail.text = moviesDetail.title
        txt_vote_average_detail_movie.text = moviesDetail.voteAverage.toString()
        txt_content_overview_detail_movie.text = moviesDetail.overview

        txt_release_date_detail_movie.text = formatDatePremiere
        if (moviesDetail.originalLanguage.equals("en")){
            txt_original_language.text = "English"
        }else if(moviesDetail.originalLanguage.equals("ja")){
            txt_original_language.text = "Japan"
        }else if(moviesDetail.originalLanguage.equals("fr")){
            txt_original_language.text = "France"
        }else{
            txt_original_language.text = ""
        }

        txt_vote_average_detail_movie.text = convertVoteAvg
        bar_rating_chart_detail_movie.rating = valForRateBar.toFloat()

    }


}
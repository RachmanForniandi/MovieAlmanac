package com.example.moviealmanac.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.moviealmanac.BuildConfig.BASE_URL_IMAGE_DROP_PATH
import com.example.moviealmanac.BuildConfig.BASE_URL_IMAGE_POSTER_PATH
import com.example.moviealmanac.R
import com.example.moviealmanac.models.FilmDummy
import com.example.moviealmanac.movies.MoviesViewModel
import com.example.moviealmanac.utility.getStringDate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_scrolling_movie.*
import kotlinx.android.synthetic.main.detail_movie_fragment.*
import kotlinx.android.synthetic.main.item_movie.*
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieDetailFragment : Fragment() {

    companion object {
        fun newInstance() = MovieDetailFragment()
    }

    private lateinit var viewModel: MoviesViewModel
    private var filmDummy:FilmDummy?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.detail_movie_fragment, container, false)
        
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: MovieDetailFragmentArgs by navArgs()
        filmDummy = args.movieDetails

        loadDetailDataMovie(viewModel.moviesDetail(0))
    }

    private fun loadDetailDataMovie(moviesDetail: FilmDummy) {
        /*Glide.with(requireActivity())
            .load(moviesDetail.backdropPath)
            .error(R.drawable.place_holder)
            .centerCrop()
            .into(img_back_drop)*/
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

        val convertVoteAvg =moviesDetail.voteAverage.toString()
        val valRating = moviesDetail.voteAverage?.div(2.0)
        val valForRateBar= valRating.toString()
        val formatDatePremiere:String = moviesDetail.releaseDate?.let {  getStringDate(it) }?: "-"


        txt_title_movie_detail.text = moviesDetail.title
        txt_vote_average_detail_movie.text = moviesDetail.voteAverage.toString()
        txt_content_overview_detail_movie.text = moviesDetail.overview

        txt_release_date_detail_movie.text = formatDatePremiere
        if (moviesDetail.originalLanguage.equals("en")){
            txt_release_date_detail_movie.text = "English"
        }else if(moviesDetail.originalLanguage.equals("ja")){
            txt_release_date_detail_movie.text = "Japan"
        }else if(moviesDetail.originalLanguage.equals("fr")){
            txt_release_date_detail_movie.text = "France"
        }else{
            txt_release_date_detail_movie.text = ""
        }

        txt_vote_average_detail_movie.text = convertVoteAvg
        bar_rating_chart_detail_movie.rating = valForRateBar.toFloat()



    }

    private fun observeDetail() {
        /*viewModel.dummyLiveData.observe(viewLifecycleOwner, Observer { detail ->
            detail.let {
                val backDropPathUrl = BASE_URL_IMAGE_DROP_PATH + detail.backdropPath
                Picasso.get()
                        .load(backDropPathUrl)
                        .placeholder(R.drawable.place_holder)
                        .error(R.drawable.place_holder)
                        .fit().centerCrop()
                        .into(img_back_drop)

                val posterPathUrl = BASE_URL_IMAGE_POSTER_PATH + detail.posterPath
                Picasso.get()
                        .load(posterPathUrl)
                        .placeholder(R.drawable.place_holder)
                        .error(R.drawable.place_holder)
                        .fit().centerCrop()
                        .into(img_poster_detail)

                txt_title_movie_detail.text = detail?.title
                txt_vote_average_detail.text = detail?.voteAverage.toString()
                txt_content_overview.text = detail?.overview


            }
        })*/
    }

}
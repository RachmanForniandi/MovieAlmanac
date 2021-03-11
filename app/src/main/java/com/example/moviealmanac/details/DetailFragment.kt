package com.example.moviealmanac.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.moviealmanac.BuildConfig.BASE_URL_IMAGE_DROP_PATH
import com.example.moviealmanac.BuildConfig.BASE_URL_IMAGE_POSTER_PATH
import com.example.moviealmanac.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.android.synthetic.main.detail_fragment.*

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: DetailViewModel
    private var keyId = 0
    private var bundle = Bundle()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
        
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        viewModel.fetchDetailData()

        arguments.let {
            keyId = bundle.getInt("keyId")
        }

        observeDetail()
    }

    private fun observeDetail() {
        viewModel.dummyLiveData.observe(viewLifecycleOwner, Observer { detail ->
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
        })
    }

}
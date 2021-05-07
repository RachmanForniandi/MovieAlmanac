package com.example.moviealmanac.tvShow

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.moviealmanac.R
import com.example.moviealmanac.adapters.MovieAdapter
import com.example.moviealmanac.models.FilmDummy
import com.example.tvShowalmanac.tvShow.TvShowViewModel
import kotlinx.android.synthetic.main.movies_fragment.*
import kotlinx.android.synthetic.main.movies_fragment.txt_no_data
import kotlinx.android.synthetic.main.tv_show_fragment.*

class TvShowFragment : Fragment() {

    companion object {
        fun newInstance() = TvShowFragment()
    }

    private lateinit var viewModel: TvShowViewModel
    private val tvShowAdapter = MovieAdapter(arrayListOf())

    /*private val movieObserver = Observer<List<FilmDummy>>{ list ->
        list.let {
            list_tvShow_data.visibility = View.VISIBLE
            //tvShowAdapter.updateDataMovie(it)
        }
    }*/

    /*private val loadObserver = Observer<Boolean>{ isLoading->
        pg_tv_show.visibility = if (isLoading)View.VISIBLE else View.GONE
        if (isLoading){
            txt_no_data.visibility = View.GONE
            list_tvShow_data.visibility = View.GONE
        }
    }

    private val errorTestObserver = Observer<Boolean> { message ->
        txt_no_data.visibility = if (message)View.VISIBLE else View.GONE
        img_no_tv_show.visibility = if (message)View.VISIBLE else View.GONE
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tv_show_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(TvShowViewModel::class.java)
        viewModel.generateDummyTvShow()

        list_tvShow_data.apply {
            adapter = tvShowAdapter
        }

        observeViewModelTvShow()
    }

    private fun observeViewModelTvShow() {
        viewModel.tvShows.observe(viewLifecycleOwner, { tvShows ->
            tvShows.let {
            list_tvShow_data.visibility = View.VISIBLE
                tvShowAdapter.updateDataMovie(tvShows)
            }
        })

        viewModel.loadingTvShows.observe(viewLifecycleOwner, { isLoading ->
            isLoading?.let {
                pg_tv_show.visibility = if (it)View.VISIBLE else View.GONE
                if (it){
                    txt_no_data.visibility = View.GONE
                    list_tvShow_data.visibility = View.GONE
                }
            }
        })
        viewModel.tvShowsLoadError.observe(viewLifecycleOwner,{message ->
            message.let {
                txt_no_data.visibility = if (message)View.VISIBLE else View.GONE
                img_no_tv_show.visibility = if (message)View.VISIBLE else View.GONE
            }
        })
    }



}
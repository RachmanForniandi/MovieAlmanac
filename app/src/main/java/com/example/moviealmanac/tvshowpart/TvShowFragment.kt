package com.example.moviealmanac.tvshowpart

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviealmanac.R
import com.example.moviealmanac.adapters.TvShowAdapter
import kotlinx.android.synthetic.main.movies_fragment.txt_no_data
import kotlinx.android.synthetic.main.tv_show_fragment.*

class TvShowFragment : Fragment() {

    companion object {
        fun newInstance() = TvShowFragment()
    }

    private lateinit var viewModel: TvShowViewModel
    private val tvShowAdapter = TvShowAdapter(arrayListOf())


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

        swipeRefreshTvShow.setOnRefreshListener {
            list_tvShow_data.visibility = View.GONE
            txt_no_data.visibility = View.GONE
            pg_tv_show.visibility = View.VISIBLE
            viewModel.generateDummyTvShow()
            swipeRefreshTvShow.isRefreshing = false
        }

        Log.e("testTv","testTv"+ observeViewModelTvShow())
    }

    private fun observeViewModelTvShow() {
        viewModel.tvShows.observe(viewLifecycleOwner, { tvShows ->
            tvShows.let {
            list_tvShow_data.visibility = View.VISIBLE
                tvShowAdapter.setDataTvShow(tvShows)
            }
        })

        viewModel.loadingTvShows.observe(viewLifecycleOwner, { isLoading ->
            isLoading?.let {
                pg_tv_show.visibility = if (it)View.VISIBLE else View.GONE
                if (it){
                    txt_no_data_tv_show.visibility = View.GONE
                    list_tvShow_data.visibility = View.GONE
                }
            }
        })
        viewModel.tvShowsLoadError.observe(viewLifecycleOwner,{message ->
            message.let {
                txt_no_data_tv_show.visibility = if (message)View.VISIBLE else View.GONE
                img_no_tv_show.visibility = if (message)View.VISIBLE else View.GONE
            }
        })
    }



}
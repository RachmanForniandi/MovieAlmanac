package com.example.moviealmanac.tvshowpart

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.moviealmanac.R
import com.example.moviealmanac.adapters.TvShowAdapter
import com.example.moviealmanac.models.FilmDummy
import com.example.moviealmanac.models.TvShowDummy
import com.example.moviealmanac.ui.main.MainFragmentDirections
import kotlinx.android.synthetic.main.tv_show_fragment.*

class TvShowFragment : Fragment() {

    /*companion object {
        fun newInstance() = TvShowFragment()
    }*/

    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var tvShowDummy: List<TvShowDummy>
    private val tvShowAdapter = TvShowAdapter(this@TvShowFragment,arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tv_show_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvShowViewModel = ViewModelProvider(this).get(TvShowViewModel::class.java)

        tvShowViewModel.responseOnGenerateDummyTvShow()
        tvShowDummy = tvShowViewModel.tvShows

        list_tvShow_data.apply {
            adapter = tvShowAdapter
            tvShowAdapter.setDataTvShow(tvShowDummy)
        }

        observeViewModelTvShow()

        swipeRefreshTvShow.setOnRefreshListener {
            list_tvShow_data.visibility = View.GONE
            txt_no_data_tv_show.visibility = View.GONE
            pg_tv_show.visibility = View.VISIBLE
            tvShowDummy
            swipeRefreshTvShow.isRefreshing = false
        }

        Log.e("testTv","testTv"+ observeViewModelTvShow())
    }

    private fun observeViewModelTvShow() {
        /*tvShowViewModel.tvShows.observe(viewLifecycleOwner, { tvShows ->
            tvShows.let {
            list_tvShow_data.visibility = View.VISIBLE
                tvShowAdapter.setDataTvShow(tvShows)
            }
        })*/

        tvShowViewModel.loadingTvShows.observe(viewLifecycleOwner, { isLoading ->
            isLoading?.let {
                pg_tv_show.visibility = if (it)View.VISIBLE else View.GONE
                if (it){
                    txt_no_data_tv_show.visibility = View.GONE
                    list_tvShow_data.visibility = View.GONE
                }
            }
        })
        tvShowViewModel.tvShowsLoadError.observe(viewLifecycleOwner,{message ->
            message.let {
                txt_no_data_tv_show.visibility = if (message)View.VISIBLE else View.GONE
                img_no_tv_show.visibility = if (message)View.VISIBLE else View.GONE
            }
        })
    }

    fun toTvShowDetails(tvShowDummy: TvShowDummy){
        /*findNavController().navigate(TvShowFragmentDirections
                .actionNavigationTvShowsToNavigationDetailsTvShow(tvShowDummy))*/
        /*findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToNavigationTvShowDetails
                (tvShowDummy))*/
    }



}
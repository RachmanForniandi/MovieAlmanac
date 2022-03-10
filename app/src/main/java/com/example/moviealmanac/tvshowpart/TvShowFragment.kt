package com.example.moviealmanac.tvshowpart

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.example.moviealmanac.R
import com.example.moviealmanac.adapters.TvShowAdapter
import com.example.moviealmanac.models.TvShowDummy
import kotlinx.android.synthetic.main.tv_show_fragment.*

class TvShowFragment : Fragment() {



    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var tvShowDummy: List<TvShowDummy>
    private val tvShowAdapter = TvShowAdapter(arrayListOf())


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
            tvShowAdapter.setOnItemClickListener(object: TvShowAdapter.OnItemClickListener{
                override fun onItemClicked(tvShow: TvShowDummy) {
                    toTvShowDetails(tvShow)
                }
            } )
        }

        observeViewModelTvShow()

        swipeRefreshTvShow.setOnRefreshListener {
            val handler = Handler()
            handler.postDelayed({
                swipeRefreshTvShow.isRefreshing = false
            }, 3000)
        }

        Log.e("testTv","testTv"+ observeViewModelTvShow())
    }

    private fun observeViewModelTvShow() {

        tvShowViewModel.loadingTvShows.observe(viewLifecycleOwner) { isLoading ->
            isLoading?.let {
                pg_tv_show.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    txt_no_data_tv_show.visibility = View.GONE
                    list_tvShow_data.visibility = View.GONE
                }
            }
        }
        tvShowViewModel.tvShowsLoadError.observe(viewLifecycleOwner,{message ->
            message.let {
                txt_no_data_tv_show.visibility = if (message)View.VISIBLE else View.GONE
                img_no_tv_show.visibility = if (message)View.VISIBLE else View.GONE
            }
        })
    }

    fun toTvShowDetails(tvShowDummy: TvShowDummy){

        val bundle = bundleOf("tvShowId" to tvShowDummy.id)
        view?.let {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_tvShowDetailFragment,bundle)
            Log.e("checkBundle",""+bundle)
        }
    }


companion object {
        fun newInstance() = TvShowFragment()
    }
}
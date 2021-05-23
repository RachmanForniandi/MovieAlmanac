package com.example.moviealmanac.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviealmanac.R

class TvShowDetailFragment : Fragment() {

    companion object {
        fun newInstance() = TvShowDetailFragment()
    }

    private lateinit var viewModel: TvShowDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.tv_show_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TvShowDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
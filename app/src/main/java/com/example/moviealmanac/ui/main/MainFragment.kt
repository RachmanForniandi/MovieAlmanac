package com.example.moviealmanac.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.moviealmanac.R
import com.example.moviealmanac.movies.MoviesFragment
import com.example.moviealmanac.tvshowpart.TvShowFragment
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(activity as AppCompatActivity){
            val adapter = TabAdapter(childFragmentManager)

            viewPager_Main.adapter = adapter
            tabLayout_Main.setupWithViewPager(viewPager_Main)
        }
    }



    class TabAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

        private val tabName: Array<String> = arrayOf("Movies", "Tv Show")
        override fun getCount(): Int = 2

        override fun getItem(position: Int): Fragment = when (position) {
            0 -> MoviesFragment()
            1 -> TvShowFragment()
            else -> MoviesFragment()
        }

        override fun getPageTitle(position: Int): CharSequence =tabName[position]

    }
}

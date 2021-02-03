package com.example.moviealmanac.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.moviealmanac.R
import com.example.moviealmanac.movies.MoviesFragment
import com.example.moviealmanac.tvShow.TvShowFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.elevation = 0.0f
        val adapter = TabAdapter(
                supportFragmentManager,
                BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
       viewPager_Main.adapter = adapter


        tabLayout_Main.setupWithViewPager(viewPager_Main)

    }
}

class TabAdapter(fragmentManager: FragmentManager, behavior: Int) : FragmentStatePagerAdapter(fragmentManager, behavior){

    private val tabName: Array<String> = arrayOf("Movies", "Tv Show")
    override fun getCount(): Int =2

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> MoviesFragment()
        1 -> TvShowFragment()
        else -> MoviesFragment()
    }

    override fun getPageTitle(position: Int): CharSequence =tabName[position]

}

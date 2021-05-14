package com.example.moviealmanac.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.moviealmanac.R
import com.example.moviealmanac.movies.MoviesFragment
import com.example.moviealmanac.tvShow.TvShowFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navy_host_fragment) as NavHostFragment
        //NavigationUI.setupActionBarWithNavController(this,navController)
        val navyController: NavController  = navHostFragment.navController
        supportActionBar?.elevation = 0.0f
        val adapter = TabAdapter(
                supportFragmentManager,
                BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        viewPager_Main.adapter = adapter

        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_movies,R.id.navigation_tv_shows)
        )
        tabLayout_Main.setupWithViewPager(viewPager_Main)
        //NavigationUI.setupWithNavController(tabLayout_Main,navyController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navy_host_fragment).navigateUp()
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

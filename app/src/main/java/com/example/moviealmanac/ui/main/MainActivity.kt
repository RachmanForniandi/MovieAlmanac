package com.example.moviealmanac.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviealmanac.R

class MainActivity : AppCompatActivity() {
    //private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val mainManager = supportFragmentManager
        val mainFragment = MainFragment()
        /*val fragmentTag = mainManager.findFragmentByTag(MainFragment::class.java.simpleName)
        if (fragmentTag is MainFragment){
            mainManager
                .beginTransaction()
                .add(R.id.main_container,mainFragment,MainFragment::class.java.simpleName)
                .commit()
        }*/
        //addMainFragment(mainFragment)
        supportActionBar?.elevation = 0.0f


    }

    private fun addMainFragment(fragment: MainFragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container,fragment,fragment.javaClass.simpleName)
                .commitNow()
    }

    /*override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navy_host_fragment).navigateUp()
    }*/
}

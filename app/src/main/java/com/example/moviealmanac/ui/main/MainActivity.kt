package com.example.moviealmanac.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.moviealmanac.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*navController = Navigation.findNavController(this,R.id.navy_host_fragment)
        val configuration: AppBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()
        NavigationUI.setupActionBarWithNavController(this,navController,configuration)*/
        supportActionBar?.elevation = 0.0f

    }


    /*override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }*/
}

package com.example.moviealmanac.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviealmanac.R

class DetailActivity : AppCompatActivity() {
    //private lateinit var viewModel: DetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(findViewById(R.id.toolbar))
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieDetailFragment.newInstance())
                .commitNow()
        }
        /*viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        //findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title

        viewModel.fetchDetailData()*/

    /*findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
    }
}
package com.example.moviealmanac.movies

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.moviealmanac.R
import com.example.moviealmanac.adapters.MovieAdapter
import com.example.moviealmanac.details.DetailActivity
import com.example.moviealmanac.models.FilmDummy
import kotlinx.android.synthetic.main.movies_fragment.*
import org.jetbrains.anko.support.v4.startActivity

class MoviesFragment : Fragment() {

    /*companion object {
        fun newInstance() = MoviesFragment()
    }*/

    companion object {
        const val KEY_ID = "01"
    }
    private lateinit var viewModel: MoviesViewModel
    lateinit var movieAdapter: MovieAdapter

    private val movieObserver = Observer<List<FilmDummy>>{list ->
        list.let {
            list_movie_data.visibility = View.VISIBLE
            movieAdapter.updateDataMovie(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        viewModel.movies.observe(viewLifecycleOwner,movieObserver)
        viewModel.loading.observe(viewLifecycleOwner,loadObserver)
        viewModel.moviesLoadError.observe(viewLifecycleOwner,errorTestObserver)
        setupAdapterListener()
        
        viewModel.generateDummyMovie()
        swipeRefreshMovie.setOnRefreshListener {
            list_movie_data.visibility = View.GONE
            txt_no_data.visibility = View.GONE
            pg_movie.visibility = View.VISIBLE
            viewModel.generateDummyMovie()
            swipeRefreshMovie.isRefreshing = false
        }

    }


    private fun setupAdapterListener() {
        list_movie_data.adapter = MovieAdapter(arrayListOf(),object :MovieAdapter.OnClickItem{
            override fun itemClick(item: FilmDummy?) {
                startActivity<DetailActivity>(
                        KEY_ID to item
                )
            }
        })

    }
    private val loadObserver = Observer<Boolean>{ isLoading->
        pg_movie.visibility = if (isLoading)View.VISIBLE else View.GONE
        if (isLoading){
            txt_no_data.visibility = View.GONE
            list_movie_data.visibility = View.GONE
        }
    }

    private val errorTestObserver = Observer<Boolean> { message ->
        txt_no_data.visibility = if (message)View.VISIBLE else View.GONE
        img_no_movie.visibility = if (message)View.VISIBLE else View.GONE
    }
    /*private fun movieObserver() {
        viewModel.loading.observe(viewLifecycleOwner, { showLoadingMovie(it) })

        *//*viewModel.movies.observe(viewLifecycleOwner, { movies ->
            movies.let {
                list_movie_data.visibility = View.VISIBLE
            }
        })*//*
        //list_movie_data.adapter =movieAdapter



    }

    private fun showLoadingMovie(it: Boolean?) {
        if (it == true){
            pg_movie.show()
        }else{
            pg_movie.hide()
        }
    }*/

}
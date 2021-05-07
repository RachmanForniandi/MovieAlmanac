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
    private val movieAdapter= MovieAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        
        viewModel.generateDummyMovie()

        list_movie_data.apply {
            adapter = movieAdapter
        }
        observeViewModel()

        swipeRefreshMovie.setOnRefreshListener {
            list_movie_data.visibility = View.GONE
            txt_no_data.visibility = View.GONE
            pg_movie.visibility = View.VISIBLE
            viewModel.generateDummyMovie()
            swipeRefreshMovie.isRefreshing = false
        }

    }

    private fun observeViewModel() {
        viewModel.movies.observe(viewLifecycleOwner, { movies ->
            movies.let {
                list_movie_data.visibility = View.VISIBLE
                movieAdapter.updateDataMovie(it)
            }
        })

        viewModel.loading.observe(viewLifecycleOwner,{isLoading->
            isLoading.let {
                pg_movie.visibility = if (it)View.VISIBLE else View.GONE
                if (it){
                    txt_no_data.visibility = View.GONE
                    list_movie_data.visibility = View.GONE
                }
            }
        })

        viewModel.moviesLoadError.observe(viewLifecycleOwner,{message ->
            message.let {
                txt_no_data.visibility = if (message)View.VISIBLE else View.GONE
                img_no_movie.visibility = if (message)View.VISIBLE else View.GONE
            }
        })
    }

}
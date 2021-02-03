package com.example.moviealmanac.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviealmanac.BuildConfig
import com.example.moviealmanac.R
import com.example.moviealmanac.models.FilmDummy
import com.example.moviealmanac.utility.getStringDate
import kotlinx.android.synthetic.main.item_movie.view.*
import kotlin.math.roundToInt

class MovieAdapter (private val data: ArrayList<FilmDummy>): RecyclerView.Adapter<MovieAdapter.MovieHolder>(){

    //private var listMovies = ArrayList<FilmDummy>()
    //private val clicked: OnClickItem 

    fun updateDataMovie(cinema:List<FilmDummy>?){
        if (cinema == null) return
        data.clear()
        data.addAll(cinema)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
        /*holder.itemView.setOnClickListener {
            clicked.movieClick(item)
        }*/

    }

    inner class MovieHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(item: FilmDummy) {
            val convertVote =item.voteAverage?.div(10.0)?.times(100.0)?.roundToInt().toString()
            with(itemView){

                val formatDatePremiere:String = item.releaseDate?.let {  getStringDate(it)}?: "-"

                tv_title_movie.text = item.title
                tv_release_date.text = formatDatePremiere
                txt_vote_rating.text = convertVote
                Glide.with(context)
                        .load(BuildConfig.BASE_URL_IMAGE+ item.posterPath)
                        .apply(RequestOptions.placeholderOf(R.drawable.place_holder)
                                .error(R.drawable.ic_error))
                        .into(img_movie_poster)
            }
        }

    }

    override fun getItemCount(): Int =data.size

    /*interface OnClickItem {
        fun movieClick(item:FilmDummy?)

    }*/
}



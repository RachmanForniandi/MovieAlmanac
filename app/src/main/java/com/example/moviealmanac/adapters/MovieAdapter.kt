package com.example.moviealmanac.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviealmanac.BuildConfig
import com.example.moviealmanac.R
import com.example.moviealmanac.models.FilmDummy
import com.example.moviealmanac.utility.getStringDate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*
import kotlin.math.roundToInt

class MovieAdapter (private val data: ArrayList<FilmDummy>): RecyclerView.Adapter<MovieAdapter.MovieHolder>(){

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
            clickListener.itemClick(item)
        }*/

    }

    inner class MovieHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(item: FilmDummy) {
            //val convertVote =item.voteAverage?.div(10.0)?.times(100.0)?.roundToInt().toString()
            with(itemView){

                val formatDatePremiere:String = item.releaseDate?.let {  getStringDate(it)}?: "-"

                tv_title_movie.text = item.title
                tv_release_date.text = formatDatePremiere
                txt_origin_language.text = item.originalLanguage
                Picasso
                    .get()
                    .load(BuildConfig.BASE_URL_IMAGE_POSTER_PATH+ item.posterPath)
                    .placeholder(R.drawable.place_holder)
                            //.override(80, 60)
                    .error(R.drawable.ic_error)
                    .centerCrop()
                    .fit()
                    //.resize(120, 160)
                    .into(img_movie_poster)
                itemView.setOnClickListener {
                    val intent = Intent()
                    "toDetail" as FilmDummy

                }
            }

        }

    }

    override fun getItemCount(): Int =data.size

    interface OnClickItem {
        fun itemClick(item:FilmDummy?)
    }
}



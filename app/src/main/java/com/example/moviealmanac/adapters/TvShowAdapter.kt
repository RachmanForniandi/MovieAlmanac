package com.example.moviealmanac.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviealmanac.BuildConfig
import com.example.moviealmanac.R
import com.example.moviealmanac.models.FilmDummy
import com.example.moviealmanac.models.TvShowDummy
import com.example.moviealmanac.utility.getStringDate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*
import kotlinx.android.synthetic.main.item_tv_show.view.*
import kotlinx.android.synthetic.main.item_tv_show.view.txt_origin_language

class TvShowAdapter (private val data: List<TvShowDummy>): RecyclerView.Adapter<TvShowAdapter.TvShowHolder>(){

    private var listTvShows = ArrayList<TvShowDummy>()

    fun setDataTvShow(tvShow:List<TvShowDummy>){
        if (tvShow == null) return
        listTvShows.clear()
        listTvShows.addAll(tvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tv_show,parent,false)
        return TvShowHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowHolder, position: Int) {
        val item = data[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class TvShowHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(item: TvShowDummy) {
            val convertVoteAvg =item.voteAverage.toString()
            val valRating = item.voteAverage?.div(2.0)
            val valForRateBar= valRating.toString()


            with(itemView){

                val formatDatePremiere:String = item.firstAirDate?.let {  getStringDate(it) }?: "-"

                tv_name_tv_show.text = item.name
                tv_release_date.text = formatDatePremiere
                if (item.originalLanguage.equals("en")){
                    txt_origin_language.text = "English"
                }else if(item.originalLanguage.equals("ja")){
                    txt_origin_language.text = "Japan"
                }else if(item.originalLanguage.equals("fr")){
                    txt_origin_language.text = "France"
                }else{
                    txt_origin_language.text = ""
                }
                //txt_origin_language.text = item.originalLanguage
                tv_tv_show_rating_value.text = convertVoteAvg
                tv_show_rate_rating_bar.rating = valForRateBar.toFloat()

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
                /*itemView.setOnClickListener {
                    val intent = Intent()
                    "toDetail" as FilmDummy

                }*/


            }
        }



    }

    interface OnClickItem {
        fun tvShowClick(item:TvShowDummy?)

    }


}
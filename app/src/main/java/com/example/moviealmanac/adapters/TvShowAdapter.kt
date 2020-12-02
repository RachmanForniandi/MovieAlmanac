package com.example.moviealmanac.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviealmanac.R
import com.example.moviealmanac.models.TvShowDummy
import kotlinx.android.synthetic.main.item_movie.view.tv_release_date
import kotlinx.android.synthetic.main.item_tv_show.view.*

class TvShowAdapter (private val data: List<TvShowDummy>, private val clicked: TvShowAdapter.OnClickItem): RecyclerView.Adapter<TvShowAdapter.TvShowHolder>(){

    private var listTvShows = ArrayList<TvShowDummy>()

    fun setDataTvShow(tvShow:List<TvShowDummy>?){
        if (tvShow == null) return
        listTvShows.clear()
        listTvShows.addAll(tvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tv_show,parent,false)
        return TvShowHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowHolder, position: Int) {
        val item = data.get(position)

        holder.titleTvShow.text = item.name
        holder.releaseDate.text = item.firstAirDate
        holder.overViewTvShow.text = item.overview

        holder.itemView.setOnClickListener {
            clicked.tvShowClick(item)
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class TvShowHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        val titleTvShow = itemView.tv_title_tv_show
        val releaseDate = itemView.tv_release_date
        val overViewTvShow = itemView.tv_overview_tv_show
        val imgTvShowPoster = itemView.img_tv_show_poster

    }

    interface OnClickItem {
        fun tvShowClick(item:TvShowDummy?)

    }


}
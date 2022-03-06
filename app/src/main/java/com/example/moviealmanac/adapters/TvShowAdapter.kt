package com.example.moviealmanac.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.moviealmanac.BuildConfig
import com.example.moviealmanac.R
import com.example.moviealmanac.models.TvShowDummy
import com.example.moviealmanac.utility.getStringDate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_tv_show.view.*
import kotlinx.android.synthetic.main.item_tv_show.view.txt_origin_language

class TvShowAdapter ( private val listTvShows: ArrayList<TvShowDummy>): RecyclerView.Adapter<TvShowAdapter.TvShowHolder>(){

    private var onItemClickListener: OnItemClickListener? = null

    fun setDataTvShow(tvShow:List<TvShowDummy>?){
        if (tvShow == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShow)
        notifyDataSetChanged()
    }
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tv_show,parent,false)
        return TvShowHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowHolder, position: Int) {
        val item = listTvShows[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { view ->

            onItemClickListener?.onItemClicked(item)
        }

    }

    override fun getItemCount(): Int {
        return listTvShows.size
    }

    inner class TvShowHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(item: TvShowDummy) {
            //val convertVoteAvg =item.voteAverage.toString()
            //val valRating = item.voteAverage?.div(2.0)
            //val valForRateBar= valRating.toString()


            with(itemView){

                //val formatDatePremiere:String = item.firstAirDate.let {  getStringDate(it) }?: "-"

                tv_name_tv_show.text = item.name
                //tv_first_air_date.text = formatDatePremiere
                if (item.originalLanguage.equals("en")){
                    txt_origin_language.text = "English"
                }else if(item.originalLanguage.equals("ja")){
                    txt_origin_language.text = "Japan"
                }else if(item.originalLanguage.equals("fr")){
                    txt_origin_language.text = "France"
                }else{
                    txt_origin_language.text = "-"
                }
                /*tv_tv_show_rating_value.text = convertVoteAvg
                tv_show_rate_rating_bar.rating = valForRateBar.toFloat()*/

                Picasso
                        .get()
                        .load(BuildConfig.BASE_URL_IMAGE_POSTER_PATH+ item.posterPath)
                        .placeholder(R.drawable.place_holder)
                        //.override(80, 60)
                        .error(R.drawable.ic_error)
                        .centerCrop()
                        .fit()
                        //.resize(120, 160)
                        .into(img_tv_show_poster)

            }
        }

    }


    interface OnItemClickListener {
        fun onItemClicked(tvShow: TvShowDummy)
    }
}
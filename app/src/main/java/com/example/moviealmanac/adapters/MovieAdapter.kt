package com.example.moviealmanac.adapters

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

class MovieAdapter ( private val data: ArrayList<FilmDummy>): RecyclerView.Adapter<MovieAdapter.MovieHolder>(){

    private var onItemClickListener: OnItemClickListener? = null

    fun setDataMovie(cinema: List<FilmDummy>?){
        if (cinema == null) return
        this.data.clear()
        this.data.addAll(cinema)
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { view ->
            onItemClickListener?.onItemClicked(item)
        }

    }

    inner class MovieHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(item: FilmDummy) {

            //val convertVoteAvg =item.voteAverage.toString()
            //val valRating = item.voteAverage.div(2.0)
            //val valForRateBar= valRating.toString()


            with(itemView){

                //val formatDatePremiere:String = item.releaseDate.let {  getStringDate(it)}?: "-"

                tv_title_movie.text = item.title
                //tv_release_date_movie.text = formatDatePremiere
                txt_origin_language.text = item.originalLanguage
                /*if (item.originalLanguage.equals("en")){
                    txt_origin_language.text = "English"
                }else if(item.originalLanguage.equals("ja")){
                    txt_origin_language.text = "Japan"
                }else if(item.originalLanguage.equals("fr")){
                    txt_origin_language.text = "France"
                }else{
                    txt_origin_language.text = "-"
                }*/
                /*tv_rating_value.text = convertVoteAvg
                rate_rating_bar.rating = valForRateBar.toFloat()*/

                Picasso
                    .get()
                    .load(BuildConfig.BASE_URL_IMAGE_POSTER_PATH+ item.posterPath)
                    .placeholder(R.drawable.place_holder)
                    .error(R.drawable.ic_error)
                    .centerCrop()
                    .fit()
                    .into(img_movie_poster)
            }

        }

    }

    override fun getItemCount(): Int = data.size

    interface OnItemClickListener {
        fun onItemClicked(movie: FilmDummy)
    }
}



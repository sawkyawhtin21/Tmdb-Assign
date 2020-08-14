package com.skh.tmdbassign.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skh.tmdbassign.R
import com.skh.tmdbassign.model.Movies
import com.skh.tmdbassign.model.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(var moviesList: List<Result> = ArrayList<Result>()) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {


    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){



        fun bind(movies: Result) {
//            this.movies = movies
            itemView.moviesresults.text = movies.original_title

            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/"+movies.poster_path)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.moviespage)
        }


    }

    fun updateMovies(moviesList: List<Result>) {
        this.moviesList = moviesList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(moviesList.get(position))
    }



}
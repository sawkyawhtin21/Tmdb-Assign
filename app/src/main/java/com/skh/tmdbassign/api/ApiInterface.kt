package com.skh.tmdbassign.api

import com.skh.tmdbassign.model.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("top_rated")
    fun getTopRated(
        @Query("api_key") apikey: String
    ): Call<Movies>
}
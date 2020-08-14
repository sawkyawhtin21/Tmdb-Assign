package com.skh.tmdbassign.api

import com.skh.tmdbassign.model.Movies
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val BASE_URL = "https://api.themoviedb.org/3/movie/"

    companion object{
        val API_KEY = "0bf10d92d51209797358b3e248ed89d4"
    }

    private val apiInterface: ApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(
            ApiInterface::class.java
        )
    }

    fun getTopRated(
        apiKey: String
    ): Call<Movies> {
        return apiInterface.getTopRated(apiKey)
    }
}
package com.skh.tmdbassign.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skh.tmdbassign.api.ApiClient
import com.skh.tmdbassign.api.ApiClient.Companion.API_KEY
import com.skh.tmdbassign.model.Movies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VideoModel:ViewModel() {
    private var result: MutableLiveData<Movies> = MutableLiveData()
    fun getResult(): LiveData<Movies> = result

    fun loadMovies() {
        var apiClient = ApiClient()
        val call = apiClient.getTopRated(API_KEY)

        call.enqueue(object : Callback<Movies> {
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("Error>>>>", t.toString())
            }

            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                result.value = response.body()
            }

        })
    }

}
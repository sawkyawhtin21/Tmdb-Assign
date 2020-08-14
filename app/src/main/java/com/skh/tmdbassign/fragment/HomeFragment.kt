package com.skh.tmdbassign.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.skh.tmdbassign.R
import com.skh.tmdbassign.adapter.HomeAdapter
import com.skh.tmdbassign.model.Movies
import com.skh.tmdbassign.model.Result
import com.skh.tmdbassign.viewmodel.VideoModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    lateinit var videoModel : VideoModel
    lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        videoModel= ViewModelProvider(this)
            .get(VideoModel::class.java)

        homeAdapter = HomeAdapter()
        recyclerHome.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter
        }
        observeViewmodel()
    }
    private fun observeViewmodel() {
        videoModel.getResult().observe(
            viewLifecycleOwner, Observer { news ->
                homeAdapter.updateMovies(news.results)
            }
        )
    }
    override fun onResume() {
        super.onResume()
        videoModel.loadMovies()
    }


}
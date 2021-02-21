package com.warpwood.workshopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.warpwood.workshopapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val feedListAdapter = FeedListAdapter()
    private val viewModel by viewModels<FeedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.label.text = "My first Android app"

        binding.feedList.adapter = feedListAdapter
        binding.feedList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel.getFeed().observe(this) {
            feedListAdapter.setFeedItems(it)
        }
        viewModel.loadFeed()
    }
}
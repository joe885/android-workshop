package com.warpwood.workshopapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FeedViewModel : ViewModel() {

    private val feedItems = MutableLiveData<List<FeedItem>>()

    fun getFeed(): LiveData<List<FeedItem>> = feedItems

    fun loadFeed() {
        feedItems.value = listOf(
            FeedItem("First item"),
            FeedItem("Second item"),
            FeedItem("Third item")
        )
    }
}
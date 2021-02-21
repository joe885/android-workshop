package com.warpwood.workshopapp

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@KoinApiExtension
class FeedViewModel : ViewModel(), KoinComponent {

    private val feedItems = MutableLiveData<List<FeedItem>>()
    private val feedService by inject<FeedApiService>()

    fun getFeed(): LiveData<List<FeedItem>> = feedItems

    fun loadFeed() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = feedService.getFeed().items
            withContext(Dispatchers.Main) {
                feedItems.value = result
            }
        }
    }
}
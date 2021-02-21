package com.warpwood.workshopapp

import retrofit2.http.GET

interface FeedApiService {

    @GET("feed.json")
    suspend fun getFeed(): FeedResponse
}
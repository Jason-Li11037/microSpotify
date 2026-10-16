package com.example.microspotify.network

import com.example.microspotify.datamodel.Section
import retrofit2.Call
import retrofit2.http.GET

interface NetworkApi {
    @GET("feed")
    fun getHomeFeed(): Call<List<Section>>
}

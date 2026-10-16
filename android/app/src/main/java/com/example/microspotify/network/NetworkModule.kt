package com.example.microspotify.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    private const val BASE_URL = "http://10.0.2.2:8080/"

    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)// base url: 0.0.0.0:8080
            .client(OkHttpClient()) //  http object
            .addConverterFactory(GsonConverterFactory.create()) // json -> object: gson converter
            .build()
    }

}

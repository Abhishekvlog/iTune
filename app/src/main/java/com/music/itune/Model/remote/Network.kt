package com.music.itune.Model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

    companion object{
        fun getRetrofitInstance() : Retrofit{
            return Retrofit.Builder().baseUrl("https://itunes.apple.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val  getApi = getRetrofitInstance().create(ApiClient::class.java)
    }
}
package com.music.itune.Model.remote

import com.music.itune.Model.remote.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("search")
    suspend fun getMusic() : ResponseDTO
//    suspend fun getMusic(@Query("term") term : String) : ResponseDTO

}
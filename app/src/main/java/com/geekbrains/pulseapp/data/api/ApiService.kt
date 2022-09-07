package com.geekbrains.pulseapp.data.api

import com.geekbrains.pulseapp.domain.Item
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("pressure/api.php?q=get")
    fun getItems(): Single<List<Item>>

    @GET("pressure/api.php?q=post")
    fun postItem(
        @Query("date") date: String,
        @Query("time") time: String,
        @Query("pressure1") pressure1: Int,
        @Query("pressure2") pressure2: Int,
        @Query("pulse") pulse: Int
    ): Single<List<Item>>
}
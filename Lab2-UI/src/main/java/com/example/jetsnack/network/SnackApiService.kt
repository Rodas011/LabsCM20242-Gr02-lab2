package com.example.jetsnack.network

import com.example.jetsnack.model.SnackCollection
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://672e2712229a881691ef27c1.mockapi.io/Jetsnacks/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

object SnackApi {
    val retrofitService : SnackApiService by lazy {
        retrofit.create(SnackApiService::class.java)
    }
}

interface SnackApiService {
    @GET("snackCollection")
    suspend fun getSnacks(): String
}
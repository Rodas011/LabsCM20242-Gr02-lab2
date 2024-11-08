package com.example.jetsnack.data

import com.example.jetsnack.network.SnackApiService
import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

interface AppContainer {
    val snackRepository: SnackRepository
}

class DefaultAppContainer : AppContainer {

    private val baseUrl =
        "https://672e2712229a881691ef27c1.mockapi.io/Jetsnacks/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: SnackApiService by lazy {
        retrofit.create(SnackApiService::class.java)
    }

    override val snackRepository: SnackRepository by lazy {
        NetworkSnackRepository(retrofitService)
    }

}
package com.example.jetsnack.network

import com.example.jetsnack.model.Snack
import com.example.jetsnack.model.SnackCollection
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =
    "https://672e2712229a881691ef27c1.mockapi.io/Jetsnacks/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface SnackApiService {
    @GET("snackCollection")
    suspend fun getSnacks(): List<SnackCollection>
}
package com.example.jetsnack.data

import com.example.jetsnack.model.SnackCollection
import com.example.jetsnack.network.SnackApiService

interface SnackRepository {
    suspend fun getSnacks(): List<SnackCollection>
}

class NetworkSnackRepository(private val snackApiService: SnackApiService) : SnackRepository {
    override suspend fun getSnacks(): List<SnackCollection> = snackApiService.getSnacks()
}
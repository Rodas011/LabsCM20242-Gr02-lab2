package com.example.jetsnack.data

import com.example.jetsnack.model.Snack
import com.example.jetsnack.model.SnackCollection
import com.example.jetsnack.network.SnackApiService

interface SnackRepository {
    suspend fun getSnacks(): List<SnackCollection>
    suspend fun getSnack(id: Long): Snack
}

class NetworkSnackRepository(private val snackApiService: SnackApiService) : SnackRepository {
    override suspend fun getSnacks(): List<SnackCollection> = snackApiService.getSnacks()
    override suspend fun getSnack(id: Long): Snack = snackApiService.getSnack(id)

}
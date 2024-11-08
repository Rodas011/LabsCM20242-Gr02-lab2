package com.example.jetsnack.ui.home

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.jetsnack.model.Filter


import com.example.jetsnack.model.snacks

class SnackFilterWorker(
    context: Context,
    workerParameters: WorkerParameters

): CoroutineWorker(context, workerParameters){
    override suspend fun doWork(): Result {

        val category = inputData.getString("tagline") ?: return Result.failure()

        val filteredSnacks =  snacks.filter { it.tagline == category }

        val outputData = workDataOf("KEY_SNACK" to filteredSnacks)

        return Result.success(outputData)
    }


}
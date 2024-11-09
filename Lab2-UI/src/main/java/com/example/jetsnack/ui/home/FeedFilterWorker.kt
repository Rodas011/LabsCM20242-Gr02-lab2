package com.example.jetsnack.ui.home

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.jetsnack.model.snacks


class FeedFilterWorker(
    context: Context,
    workerParameters: WorkerParameters
): CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {

        val category = inputData.getString("tagline") ?: return Result.failure()

        val filteredSnacks =  snacks.filter { it.tagline == category }

        val snackArray = filteredSnacks.map { it.name }.toTypedArray()

        val outputData = Data.Builder()
            .putStringArray("KEY_SNACK", snackArray) // Store as array
            .build()

        return Result.success(outputData)
    }
}
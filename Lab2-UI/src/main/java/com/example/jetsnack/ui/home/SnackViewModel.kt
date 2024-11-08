package com.example.jetsnack.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetsnack.network.SnackApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface SnackUiState {
    data class Success(val snacks: String) : SnackUiState
    object Error : SnackUiState
    object Loading : SnackUiState
}

class SnackViewModel : ViewModel() {

    var snackUiState: SnackUiState by mutableStateOf(SnackUiState.Loading)
        private set

    init {
        getSnacks()
    }

    private fun getSnacks() {
        viewModelScope.launch {
            snackUiState = try {
                val listResult = SnackApi.retrofitService.getSnacks()
                SnackUiState.Success(listResult)
            } catch (e: IOException) {
                SnackUiState.Error
            }
        }
    }
}
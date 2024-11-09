package com.example.jetsnack.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.jetsnack.JetsnackApplication
import com.example.jetsnack.data.NetworkSnackRepository
import com.example.jetsnack.data.SnackRepository
import com.example.jetsnack.model.SnackCollection
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface SnackUiState {
    data class Success(val snacks: List<SnackCollection>) : SnackUiState
    object Error : SnackUiState
    object Loading : SnackUiState
}

class SnackViewModel(private val snackRepository: SnackRepository) : ViewModel() {

    var snackUiState: SnackUiState by mutableStateOf(SnackUiState.Loading)
        private set

    init {
        getSnacks()
    }

    private fun getSnacks() {
        viewModelScope.launch {
            snackUiState = try {
                val listResult = snackRepository.getSnacks()
                SnackUiState.Success(listResult)
            } catch (e: IOException) {
                SnackUiState.Error
            } catch (e: HttpException) {
                SnackUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as JetsnackApplication)
                val snackRepository = application.container.snackRepository
                SnackViewModel(snackRepository = snackRepository)
            }
        }
    }

}
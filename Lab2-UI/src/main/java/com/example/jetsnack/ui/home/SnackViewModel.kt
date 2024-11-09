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
import com.example.jetsnack.data.SnackRepository
import com.example.jetsnack.model.SnackCollection
import com.example.jetsnack.model.Snack
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


data class SnackUiState (
    val snacks: List<SnackCollection> = emptyList(),
    val snack: Snack? = null
)

class SnackViewModel(private val snackRepository: SnackRepository) : ViewModel() {

    private val _snackUiState = MutableStateFlow(SnackUiState())
    val snackUiState: StateFlow<SnackUiState> = _snackUiState.asStateFlow()

    var snacks: List<SnackCollection> by mutableStateOf(emptyList())
        private set

    var snack: Snack? by mutableStateOf(null)
        private set

    init {
        getSnacks()
    }

    private fun getSnacks() {
        viewModelScope.launch {
            val listResult = snackRepository.getSnacks()
            _snackUiState.value = SnackUiState(snacks = listResult)
        }
    }

    fun getSnack(snackId: Long) {
        viewModelScope.launch {
            val snackResult = snackRepository.getSnack(snackId)
            _snackUiState.value = _snackUiState.value.copy(snack = snackResult)
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
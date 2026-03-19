package com.example.user_direcory_application.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

sealed interface DirectoryUiState {
    data class Success(val photos: String) : DirectoryUiState
    object  Error : DirectoryUiState
    object  Loading : DirectoryUiState
}

class DirectoryViewModel : ViewModel() {
    var directoryUiState: DirectoryUiState by mutableStateOf(DirectoryUiState.Loading)
        private set

    init {

    }
}
package com.example.user_direcory_application.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.user_direcory_application.network.UserApi
import kotlinx.coroutines.launch

import retrofit2.HttpException
import java.io.IOException

sealed interface UserUiState {
    data class Success(val id: String) : UserUiState
    object  Error : UserUiState
    object  Loading : UserUiState
}

class UserViewModel : ViewModel() {
    var userUiState: UserUiState by mutableStateOf(UserUiState.Loading)
        private set

    init {
            getUsers()
    }

    fun getUsers(){
        viewModelScope.launch{
            userUiState = UserUiState.Loading
            userUiState = try {
                val listResult = UserApi.retrofitService.getUsers()
                UserUiState.Success(
                    "Success: ${listResult.size} Users retrieved"
                )

            } catch (e: IOException) {
                UserUiState.Error
            } catch (e: HttpException) {
                UserUiState.Error
            }
        }
    }
}
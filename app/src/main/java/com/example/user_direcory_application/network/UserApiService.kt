package com.example.user_direcory_application.network


import com.example.user_direcory_application.model.User
import com.example.user_direcory_application.model.UserResponse
import com.example.user_direcory_application.model.json
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET


private const val BASE_URL =
    "https://dummyjson.com/users/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

interface UserApiService {
        @GET("1")
        suspend fun getId(): User
}

object UserApi {
    val retrofitService: UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }
}
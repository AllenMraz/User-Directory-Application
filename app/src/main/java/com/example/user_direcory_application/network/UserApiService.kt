package com.example.user_direcory_application.network


import com.example.user_direcory_application.model.Users
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
//"https://dummyjson.com/users?limit=20"

private const val BASE_URL =
    "https://dummyjson.com/users/?limit=20"

private val retrofit = Retrofit.Builder().addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

interface UserApiService {
        @GET("users")
        suspend fun getId(): List<Users>
}

object UserApi {
    val retrofitService: UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }
}
package com.example.user_direcory_application.network


import com.example.user_direcory_application.model.UserResponse
import com.example.user_direcory_application.model.json
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

// the url base for the api
private const val BASE_URL =
    "https://dummyjson.com"
// builds the link to the api
private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

// interface to get data and put it into a UserResponse object
interface UserApiService {
        @GET("user")
        suspend fun getId(): UserResponse

}

// an object the incoperatests the UserApiService
object UserApi {
    val retrofitService: UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }
}
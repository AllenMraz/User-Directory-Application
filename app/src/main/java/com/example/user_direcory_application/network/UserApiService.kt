package com.example.user_direcory_application.network


import com.example.user_direcory_application.model.Users
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL =
    "https://dummyjson.com/users?limit=20"

private val retrofit = Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

interface UserApiService {
        @GET("users")
        suspend fun getUsers(): List<Users>
}

object UserApi {
    val retrofitService: UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }
}
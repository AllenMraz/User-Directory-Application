package com.example.user_direcory_application.model


import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val image: String
)
val json = Json { ignoreUnknownKeys = true }
@Serializable
data class UserResponse(
    val users: List<User>
)


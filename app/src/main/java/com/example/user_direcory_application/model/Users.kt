package com.example.user_direcory_application.model


import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
// class for the structer of user
data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val image: String
)

val json = Json { ignoreUnknownKeys = true }
// class that houlds a list of users
@Serializable
data class UserResponse(
    val users: List<User>
)


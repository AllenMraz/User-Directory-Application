package com.example.user_direcory_application.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Users(
    val id: String,
    val firstName: String
)
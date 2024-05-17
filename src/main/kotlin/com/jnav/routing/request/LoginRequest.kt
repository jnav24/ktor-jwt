package com.jnav.routing.request

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest (
    val username: String,
    val password: String,
)

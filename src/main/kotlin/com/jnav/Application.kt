package com.jnav

import com.jnav.plugins.configureSecurity
import com.jnav.plugins.configureSerialization
import com.jnav.repository.UserRepository
import com.jnav.routing.configureRouting
import com.jnav.service.JwtService
import com.jnav.service.UserService
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val userRepository = UserRepository()
    val userService = UserService(userRepository)
    val jwtService = JwtService(this, userService)

    configureSerialization()
    configureSecurity(jwtService)
    configureRouting(userService, jwtService)
}

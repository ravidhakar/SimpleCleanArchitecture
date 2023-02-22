package com.cleanarchitectureexample.domain.model

import com.cleanarchitectureexample.data.model.UserDTO

data class User(val name: String, val mobile: String)

fun UserDTO.toUser(): User {
    return User(name = name, mobile = mobile)
}


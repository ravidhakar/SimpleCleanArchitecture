package com.cleanarchitectureexample.domain.repository

import com.cleanarchitectureexample.data.model.UserDTO

interface UserRepository {
    suspend fun getUser(): UserDTO
}
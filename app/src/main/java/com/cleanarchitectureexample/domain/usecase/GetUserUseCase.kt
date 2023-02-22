package com.cleanarchitectureexample.domain.usecase

import com.cleanarchitectureexample.domain.model.User

interface GetUserUseCase {
    suspend fun getUser():User
}
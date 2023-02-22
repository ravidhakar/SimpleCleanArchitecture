package com.cleanarchitectureexample.data.source.remote

import com.cleanarchitectureexample.data.model.UserDTO

interface RemoteDataSource {
    suspend fun getUser(): UserDTO

}
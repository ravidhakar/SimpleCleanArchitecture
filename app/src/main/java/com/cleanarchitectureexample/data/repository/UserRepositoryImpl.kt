package com.cleanarchitectureexample.data.repository

import com.cleanarchitectureexample.data.model.UserDTO
import com.cleanarchitectureexample.data.source.remote.RemoteDataSource
import com.cleanarchitectureexample.domain.repository.UserRepository

class UserRepositoryImpl(private val dataSource: RemoteDataSource) : UserRepository {
    override suspend fun getUser(): UserDTO {
        return dataSource.getUser()
    }


}
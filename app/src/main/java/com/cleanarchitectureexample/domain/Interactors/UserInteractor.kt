package com.cleanarchitectureexample.domain.Interactors

import com.cleanarchitectureexample.domain.model.User
import com.cleanarchitectureexample.domain.model.toUser
import com.cleanarchitectureexample.domain.repository.UserRepository
import com.cleanarchitectureexample.domain.usecase.GetUserUseCase

class UserInteractor(private val userRepository: UserRepository) : GetUserUseCase {
    override suspend fun getUser(): User {
        return userRepository.getUser().toUser()
    }


}
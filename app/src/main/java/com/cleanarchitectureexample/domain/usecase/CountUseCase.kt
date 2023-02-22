package com.cleanarchitectureexample.domain.usecase

import com.cleanarchitectureexample.domain.model.Count

interface CountUseCase {
    suspend fun updateCount(count:Int)
    suspend fun getCount(): Count
}
package com.cleanarchitectureexample.domain.repository

interface CountRepo {
    suspend fun updateCount(count: Int)
    suspend fun getCount(): Int
}
package com.cleanarchitectureexample.data.source.local

interface LocalDataSource {
    suspend fun updateCount(count:Int)
    suspend fun getCount():Int
}
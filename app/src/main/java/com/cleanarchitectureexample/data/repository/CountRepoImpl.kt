package com.cleanarchitectureexample.data.repository

import com.cleanarchitectureexample.data.source.local.LocalDataSource
import com.cleanarchitectureexample.domain.repository.CountRepo


class CountRepoImpl(private val localDataSource: LocalDataSource) : CountRepo {
    override suspend fun updateCount(count: Int) {
        localDataSource.updateCount(count)
    }

    override suspend fun getCount(): Int {
        return localDataSource.getCount()
    }
}
package com.cleanarchitectureexample.domain.Interactors

import com.cleanarchitectureexample.domain.model.Count
import com.cleanarchitectureexample.domain.model.toCount
import com.cleanarchitectureexample.domain.repository.CountRepo
import com.cleanarchitectureexample.domain.usecase.CountUseCase

class CountInteractor(private val _countRepo: CountRepo) : CountUseCase {
    override suspend fun updateCount(count: Int) {
        _countRepo.updateCount(count)
    }

    override suspend fun getCount(): Count {
        return _countRepo.getCount().toCount()
    }

}
package com.cleanarchitectureexample.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.cleanarchitectureexample.domain.model.Count
import com.cleanarchitectureexample.domain.usecase.CountUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstViewModel(private val countUseCase: CountUseCase) : ViewModel() {
    private val _count = MutableLiveData<Count>()
    val count: MutableLiveData<Count> get() = _count

    fun readCount() {
        viewModelScope.launch(Dispatchers.IO) {
            _count.postValue(countUseCase.getCount())
        }
    }

    fun updateCount(count: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            countUseCase.updateCount(count)
        }
    }

    class FirstModelFactory(private val countUseCase: CountUseCase) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return FirstViewModel(countUseCase) as T
        }
    }
}
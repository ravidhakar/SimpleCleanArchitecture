package com.cleanarchitectureexample.ui.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.cleanarchitectureexample.domain.model.User
import com.cleanarchitectureexample.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SecondViewModel(private val getUserUseCase: GetUserUseCase) : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: MutableLiveData<User> get() = _user

    fun getUser() {
        viewModelScope.launch(Dispatchers.IO) {
            _user.postValue(getUserUseCase.getUser())
        }
    }

    class SecondModelFactory(private val getUserUseCase: GetUserUseCase) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SecondViewModel(getUserUseCase) as T
        }
    }
}
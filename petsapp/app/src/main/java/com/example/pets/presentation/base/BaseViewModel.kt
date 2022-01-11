package com.example.pets.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> = _error

    fun launch(block: suspend () -> Unit) {
        _loading.postValue(true)
        viewModelScope.launch {
            try {
                _error.postValue(false)
                block()
            } catch (ex: Exception) {
                _error.postValue(true)
            }
            _loading.postValue(false)
        }
    }
}